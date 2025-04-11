# TikTok App Events Slim Binding
This folder contains a slim binding which demonstrations using [TikTok App Events][0]

## Setup
The TikTok Business sdk must be added to the root of the sample folder. The SDK is distributed via [Jitpack][3], [download the aar][4]. Next the App IDs and Tik Tok App IDs must be set in app.xaml.cs.
* The App IDs come from the respective app stores
* See [Generating TikTok App IDs][2]

## Manually Building The Android Binding
These steps may or may not be required based on your machine's configuration. 

```shell
cd tiktok/android/native
./gradlew build
cd ../TikTok.Android.Binding
dotnet build -t:InstallAndroidDependencies -f net9.0-android
```

### Build and Run
```shell
    dotnet build sample -t:Run -f net9.0-android
    dotnet build sample -t:Run -f net9.0-ios
```

## Notes
* If you experience issues with missing references manually invoking gradlew build before building the dotnet project helps.
* NativeLibraryInterop depends on "CommunityToolkit.Maui.NativeLibraryInterop.BuildTasks", this package is not yet on Nuget, when migrating this sample into your project be sure to include the NuGet.Config in your project's folder.
* You will also need to add the following to your project's csproj
```
<ItemGroup Condition="$(TargetFramework.Contains('android'))">
    <AndroidLibrary Include="tiktok-business-android-sdk-1.3.8.aar">
        <CopyToOutputDirectory>Always</CopyToOutputDirectory>
    </AndroidLibrary>
</ItemGroup>

<ItemGroup>
    <PackageReference Include="CommunityToolkit.Maui.NativeLibraryInterop.BuildTasks" Version="0.0.1-pre1" PrivateAssets="all" />
</ItemGroup>
```

[0]: https://business-api.tiktok.com/portal/docs?id=1739584951798785
[1]: https://jitpack.io/com/github/tiktok/tiktok-business-android-sdk/1.3.8/tiktok-business-android-sdk-1.3.8.aar
[2]: https://business-api.tiktok.com/portal/docs?id=1739584951798785#item-link-Generate%20your%20TikTok%20App%20ID
[3]: https://jitpack.io/com/github/tiktok/tiktok-business-android-sdk/1.3.8/
[4]: https://jitpack.io/com/github/tiktok/tiktok-business-android-sdk/1.3.8/tiktok-business-android-sdk-1.3.8.aar