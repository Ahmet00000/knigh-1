# MyKO İleri — küçük Android 16 projesi

**Önemli:** Bu bir kaynak kod prototipidir, APK değil. Derlenmesi ve MyKO'da çalışması henüz doğrulanmadı.

1. ZIP'i çıkarın; Android Studio > Open ile klasörü açın.
2. SDK Platform 36 ve JDK 17 ile Gradle Sync yapın.
3. Telefonda Geliştirici seçenekleri / USB hata ayıklama açıkken USB ile bağlayın; Run'a basın.
4. Uygulamada Erişilebilirlik ve Ekran üzerinde gösterme izinlerini açın.
5. Yüzen düğmeyi açıp oyuna geçin. **İLERİ** 10 saniyelik sürükleme gönderir, **DUR** hareketi kesmeye çalışır.

**Sınırlamalar:** Joystick varsayılan koordinatları ekranın %15 genişliği, %82 yüksekliği ve ileri hedef %68 yüksekliğidir. Cihaz ekranına göre değiştirilmesi gerekebilir. `resources.displayMetrics` bazı ekranlarda tam ekran oyun koordinatlarıyla örtüşmeyebilir. Yüzen panel uygulama etkinliği kapatıldığında kaldırılabilir. Android'in erişilebilirlik hareketleri veya oyun, beklenenden farklı davranabilir. Anti-cheat atlatma yoktur; oyun kurallarını kontrol edin.
