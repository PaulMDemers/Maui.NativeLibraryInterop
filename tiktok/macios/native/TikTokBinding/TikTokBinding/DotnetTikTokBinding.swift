//
//  DotnetTikTokBinding.swift
//  TikTok
//
//  Created by .NET MAUI team on 6/18/24.
//  Modified by Paul Demers on 4/10/25.
//

import Foundation
import TikTokBusinessSDK

@objc(DotnetTikTokBinding)
public class DotnetTikTokBinding : NSObject
{

    @objc
    public static func getString(myString: String) -> String {
        return myString  + " from swift!"
    }
    
    @objc
    public static func initTikTok(appId: String, tikTokAppId: String, isDebug: Bool) -> Bool {

        // This method will be depreacted in the future. Please use the latest method.
        let config = TikTokConfig.init(appId: appId, tiktokAppId: tikTokAppId)
        //let config = TikTokConfig(accessToken: accessToken, appId: appId, tiktokAppId: tikTokAppId)

        config?.enableDebugMode()
        config?.setLogLevel(TikTokLogLevelDebug) //optional, recommended for diagnostics
        
        // You can init like this directly:
        // TikTokBusiness.initializeSdk(config)
        // But we recommend you using
        // the new api with completionHandler below
        TikTokBusiness.initializeSdk(config) { success, error in
            if (!success) { // initialization failed
                print("Tiktok init failed")
                print(error!.localizedDescription)
            } else { // initialization successful
                print("Tiktok init success")
            }
        }
        
        return true
    }
    
    @objc
    public static func logLoginEvent() {
        // Swift
        let achieveLevelEvent = TikTokBaseEvent(name: TTEventName.login.rawValue)
        TikTokBusiness.trackTTEvent(achieveLevelEvent)
    }
    
    @objc
    public static func logRegistrationEvent() {
        // Swift
        let achieveLevelEvent = TikTokBaseEvent(name: TTEventName.registration.rawValue)
        TikTokBusiness.trackTTEvent(achieveLevelEvent)
    }
    
    @objc
    public static func logSubscribeEvent() {
        // Swift
        let achieveLevelEvent = TikTokBaseEvent(name: TTEventName.subscribe.rawValue)
        TikTokBusiness.trackTTEvent(achieveLevelEvent)
    }
    
    @objc
    public static func logSpendCreditsEvent() {
        // Swift
        let achieveLevelEvent = TikTokBaseEvent(name: "SpendCredits")
        TikTokBusiness.trackTTEvent(achieveLevelEvent)
    }
    
    @objc
    public static func logEvent(name: String) {
        // Swift
        let achieveLevelEvent = TikTokBaseEvent(name: name)
        TikTokBusiness.trackTTEvent(achieveLevelEvent)
    }
}
