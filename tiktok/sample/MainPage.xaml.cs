namespace MauiSample;

#if IOS || MACCATALYST
using TTBinding = MauiTikTokiOS.DotnetTikTokBinding;
#elif ANDROID
using TTBinding = MauiTikTokAndroid.DotnetTikTokBinding;
#elif (NETSTANDARD || !PLATFORM) || (NET6_0_OR_GREATER && !IOS && !ANDROID)
using TTBinding = System.Object;
#endif

public partial class MainPage : ContentPage
{
	public MainPage()
	{
		InitializeComponent();
	}

    private void LoginEvtBtn_OnClicked(object? sender, EventArgs e)
    {
#if IOS || ANDROID
        TTBinding.LogLoginEvent();
#endif
    }

    private void RegEvtBtn_OnClicked(object? sender, EventArgs e)
    {
#if IOS || ANDROID
        TTBinding.LogRegistrationEvent();
#endif
    }

    private void SubEvtBtn_OnClicked(object? sender, EventArgs e)
    {
#if IOS || ANDROID
        TTBinding.LogSubscribeEvent();
#endif
    }

    private void SpendCreditsEvtBtn_OnClicked(object? sender, EventArgs e)
    {
#if IOS || ANDROID
        TTBinding.LogSpendCreditsEvent();
#endif
    }
}

