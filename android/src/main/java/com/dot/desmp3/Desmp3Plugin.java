package com.dot.desmp3;

import android.Manifest;
import android.content.pm.PackageManager;
import android.util.Log;

import com.getcapacitor.JSObject;
import com.getcapacitor.PermissionState;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.getcapacitor.annotation.PermissionCallback;

@CapacitorPlugin(name = "Desmp3")
public class Desmp3Plugin extends Plugin {

    private Desmp3 implementation = new Desmp3();
    @PluginMethod
    public String start(PluginCall call) {

        String value = call.getString("value");
        JSObject ret = new JSObject();
        implementation.setup(this.getContext());
        ret.put("value", implementation.start(value));
        call.resolve(ret);
        return "yes";
    }


    @PluginMethod
    public String pause(PluginCall call) {
        JSObject ret = new JSObject();
        ret.put("value", implementation.pause());
        call.resolve(ret);
        return "yes";
    }

    @PluginMethod
    public String stop(PluginCall call) {
        JSObject ret = new JSObject();
        ret.put("value", implementation.stop());
        call.resolve(ret);
        return "yes";
    }



    @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("value");

        JSObject ret = new JSObject();
        ret.put("value", implementation.echo(value));
        call.resolve(ret);
    }

}
