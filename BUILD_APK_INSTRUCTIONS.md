# APK oluşturma — Android Studio gerekmiyor

1. GitHub'da yeni bir **private** repository oluştur (ör. `myko-forward`).
2. Bu ZIP içindeki dosya ve klasörleri **repository kök dizinine** yükle. `.github/workflows/build-apk.yml` dosyasının da yüklendiğinden emin ol. ZIP dosyasını tek dosya olarak yüklemek yeterli değildir.
3. GitHub'da **Actions** sekmesine git. **Build Android APK** iş akışını aç.
4. **Run workflow** düğmesine bas ve derlemenin tamamlanmasını bekle. Alternatif olarak `main` dalına push işlemi otomatik derlemeyi başlatır.
5. Başarılı çalıştırmanın altındaki **Artifacts** bölümünden `MyKO-Forward-debug-APK` dosyasını indir.
6. Artifact ZIP'ini aç; içindeki `app-debug.apk` dosyasını Android telefonuna gönder ve yükle.
7. Telefonda erişilebilirlik ve diğer uygulamalar üzerinde gösterme izinlerini etkinleştir. Android 16 bazı kaynaklardan yüklenen uygulamaların erişilebilirlik izinlerini ek onayla kısıtlayabilir.

## Uyarılar

- Bu paket derlenmiş APK değil, GitHub üzerinde APK oluşturmak için hazır kaynak proje + iş akışıdır.
- Proje henüz gerçek Android telefonda veya MyKO Mobile'da test edilmedi.
- Yüzen panel ve joystick koordinatları oyun arayüzüne göre kalibrasyon gerektirebilir.
- Otomasyon oyunun kurallarını ihlal edebilir.
