package com.microsoft.tiktok;

import com.tiktok.TikTokBusinessSdk;
import com.tiktok.TikTokBusinessSdk.TTConfig;
import com.tiktok.appevents.*;
import com.tiktok.appevents.base.EventName;
import com.tiktok.appevents.base.TTBaseEvent;

import android.content.Context;

public class DotnetTikTokBinding
{
    public static String getString(String myString)
    {
        return myString + " from java!";
    }

    public static void InitTikTok(String appId, String tikTokAppId, Context appContext, boolean isDebug)
    {
        // Set AppId & TikTok App ID in application code
        TTConfig ttConfig = new TTConfig(appContext) //(getApplicationContext())
            .setAppId(appId) // Android package name or iOS listing ID, eg: com.sample.app (from Play Store) or 9876543 (from App Store)
            .setTTAppId(tikTokAppId); // TikTok App ID from TikTok Events Manager

        if(isDebug)
        {
            ttConfig = ttConfig
                .openDebugMode()
                .setLogLevel(TikTokBusinessSdk.LogLevel.DEBUG);
        }
        TikTokBusinessSdk.initializeSdk(ttConfig);
        //If you need to listener the initialization status, please use the initialization function with callback
        TikTokBusinessSdk.initializeSdk(ttConfig, new TikTokBusinessSdk.TTInitCallback() {
            @Override
            public void success() {
                //Initialization successful
                System.out.print("Tiktok init success");
            }

            @Override
            public void fail(int code, String msg) {
                //initialization failed
                System.out.print("Tiktok init failed");
            }
        });
        // TikTok business SDK will actually start sending app events to
        // Events API when startTrack() function is called. Before this
        // function is called, app events are merely stored locally. Delay
        // calling this function if you need to let the user agree to data terms
        // before actually sending the app events to TikTok.
        TikTokBusinessSdk.startTrack();
    }

    static void LogEvent(EventName eventName)
    {
        TikTokBusinessSdk.trackTTEvent(eventName);
    }

    public static void LogLoginEvent()
    {
        DotnetTikTokBinding.LogEvent(EventName.LOGIN);
    }

    public static void LogRegistrationEvent()
    {
        DotnetTikTokBinding.LogEvent(EventName.REGISTRATION);
    }

    public static void LogSubscribeEvent()
    {
        DotnetTikTokBinding.LogEvent(EventName.SUBSCRIBE);
    }

    public static void LogSpendCreditsEvent()
    {
        DotnetTikTokBinding.LogEvent(EventName.SPEND_CREDITS);
    }
}
