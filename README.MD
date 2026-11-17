## TP10 — Character Manager Sprint #4 (Theming & MVC)

### A. Implementasi Tema & Screenshot
* **AppTheme.java** dibuat di package `view` memuat 3 warna utama, 3 font, 1 border kustom, dan method `colorFor()`.
* **Screenshot Sebelum (v0.3):**
  *(Letakkan path gambar screenshot `screenshots/tp8-before.png` di sini)*
* **Screenshot Sesudah (v0.4):**
  *(Letakkan path gambar screenshot `screenshots/tp10-after.png` di sini)*

### B. Penjelasan Mengapa Warna Disimpan di `AppTheme` dan Bukan di `Character`
1. **Pemisahan Tanggung Jawab (Separation of Concerns):** Pengaturan warna, font, dan border adalah aspek visual antarmuka pengguna (**View**), sedangkan objek `Character` murni merepresentasikan data entitas bisnis (**Model**).
2. **Fleksibilitas Desain:** Jika suatu saat tema aplikasi diubah (misalnya dari Mode Terang ke Mode Gelap), kita hanya perlu memodifikasi kelas `AppTheme` tanpa harus mengubah struktur atau logika data di dalam kelas `Character`.

### C. Daftar Dua Properti Tambahan yang Dipilih
1. **High-Level Text Highlighting (Teks Emas & Tebal):** Karakter dengan level $\ge 5$ otomatis menampilkan nama berwarna emas dan tebal untuk memudahkan identifikasi karakter tingkat tinggi secara visual.
2. **Dynamic Card Tooltip (`setToolTipText`):** Setiap kartu karakter dilengkapi tooltip yang menampilkan detail informasi tambahan saat kursor diarahkan ke atas kartu tersebut.

### D. Analisis Analitis & MVC
Analisis lengkap mengenai JavaBeans, event-driven, layout manager, pemetaan warna, dan logical fonts telah diunggah ke Google Docs:
* **Link Google Docs:** [JavaVisual_TP10_253303621269_AlgaVancany](https://docs.google.com/document/d/1Kxv-E4ZcHrXY8oa1qOW9hKyvnrYYd0IZRMDx6knVnew/edit?usp=sharing)