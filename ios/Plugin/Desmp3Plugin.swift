import Foundation
import Capacitor
import AVFoundation
/**
 * Please read the Capacitor iOS Plugin Development Guide
 * here: https://capacitorjs.com/docs/plugins/ios
 */
@objc(Desmp3Plugin)
public class Desmp3Plugin: CAPPlugin {
    private var implementation :Desmp3?

    @objc func start(_ call: CAPPluginCall)  -> String {
        let value = call.getString("value") ?? ""
        var playItem = AVPlayerItem(url: URL(string: value)!)
        var player = AVPlayer(playerItem: playItem)
        implementation = Desmp3(player: player, despPlugin: self)
        implementation?.setup(value: self)
        call.resolve([
            "value": implementation?.start(value: value)
        ])
        return "yes"
    }
    @objc func onCompleted() {
                notifyListeners("nextSong", data: nil);
           }

        @objc func pause(_ call: CAPPluginCall)  -> String {
                call.resolve([
                    "value": implementation?.pause()
                ])
              return "yes"
    }
      
    @objc func stop(_ call: CAPPluginCall)  -> String {
                call.resolve([
                    "value": implementation?.stop()
                ])
          return "yes"
}
        @objc func echo(_ call: CAPPluginCall)  -> String {
        let value = call.getString("value") ?? ""
        call.resolve([
            "value": implementation?.echo(value)
        ])
            return "yes"
    }

}
