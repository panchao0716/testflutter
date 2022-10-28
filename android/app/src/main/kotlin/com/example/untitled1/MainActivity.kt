package com.example.untitled1

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugins.GeneratedPluginRegistrant
import org.json.JSONException
import org.json.JSONObject

class MainActivity: FlutterActivity() {

    var channel: MethodChannel? =null

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

    }

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        channel=MethodChannel(flutterEngine.dartExecutor.binaryMessenger, "plugin/test");
        channel!!.setMethodCallHandler { call, result ->
                when(call.method){
                    "Message" ->{
                        //这里接收到Android传来的数据
                        //result.success()单向返回数据

                        //method：flutter接收标识  arg：回传的数据,在任何有channel实例的地方都能回调
                        channel!!.invokeMethod("testOne","我是传回来的数据")
                    }
                }

        }
    }
}
