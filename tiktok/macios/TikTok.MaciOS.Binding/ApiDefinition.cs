using Foundation;

namespace MauiTikTokiOS
{
	// @interface DotnetTikTokBinding : NSObject
	[BaseType (typeof(NSObject))]
	interface DotnetTikTokBinding
	{
		// +(NSString * _Nonnull)getStringWithMyString:(NSString * _Nonnull)myString __attribute__((warn_unused_result("")));
		[Static]
		[Export ("getStringWithMyString:")]
		string GetString (string myString);

        [Static]
        [Export("initTikTokWithAppId:tikTokAppId:isDebug:")]
        bool InitTikTok(string appId, string tiktopAppId, bool isDebug);

        [Static]
        [Export("logLoginEvent")]
        void LogLoginEvent ();

        [Static]
        [Export("logRegistrationEvent")]
        void LogRegistrationEvent ();

        [Static]
        [Export("logSubscribeEvent")]
        void LogSubscribeEvent ();

        [Static]
        [Export("logSpendCreditsEvent")]
        void LogSpendCreditsEvent ();
    }
}
