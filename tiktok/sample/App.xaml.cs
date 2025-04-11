#if IOS || MACCATALYST
using TTBinding = MauiTikTokiOS.DotnetTikTokBinding;
#elif ANDROID
using TTBinding = MauiTikTokAndroid.DotnetTikTokBinding;
#elif (NETSTANDARD || !PLATFORM) || (NET6_0_OR_GREATER && !IOS && !ANDROID)
using TTBinding = System.Object;
#endif

namespace MauiSample;

public partial class App : Application
{
	public App()
	{
		InitializeComponent();
	}

	protected override Window CreateWindow(IActivationState? activationState)
	{
		return new Window(new AppShell());
	}

    protected override void OnStart()
    {
        base.OnStart();

#if ANDROID
        TTBinding.InitTikTok("<Android app package name, com.myapp.app>", "<TikTok app ID 12345XXXXXXX>", Android.App.Application.Context, true);
#elif IOS
        TTBinding.InitTikTok("<iOS app store id, 0123456789>", "<TikTok app ID 12345XXXXXXX>", true);
#endif
    }
}



