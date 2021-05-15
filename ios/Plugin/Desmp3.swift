import Foundation
import UIKit
import AVFoundation

@objc public class Desmp3: NSObject {

     var player = AVPlayer()
    
    public override init() {
        player = AVPlayer()
    }

   public func start(value: String) -> String {
        let playItem = AVPlayerItem(url: URL(string: value)!)
        player = AVPlayer(playerItem: playItem)
        player.play()
        return "yes"
    }
    public func pause() -> String {
        player.pause()
        return "yes"

    }
    
    public func stop() -> String {
        player.pause()
        player.rate=0
        return "yes"

    }

    public func echo(_ value: String) -> String {
        return value
    }

}
