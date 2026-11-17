
# Character Manager — TP5 (Java Visual SIH-6406)

## Deskripsi Project

Character Manager Sprint #2 merupakan pengembangan aplikasi berbasis Java untuk mengelola kumpulan objek Character menggunakan ArrayList.

Project ini menerapkan konsep Object-Oriented Programming (OOP), khususnya object reference, encapsulation, equals(), defensive copy, dan static variable.

Program menyediakan fitur CRUD sederhana serta analisis karakter berdasarkan level, jenis, dan Attack Power.

---

## A. Implementasi Core

Fitur yang dikembangkan:

1. equals() untuk membandingkan karakter berdasarkan nama.
2. addCharacter() untuk menambahkan karakter.
3. findByName() untuk mencari karakter.
4. removeCharacter() untuk menghapus karakter.
5. getTotalCharacters() untuk menghitung jumlah karakter.
6. getAllCharacters() untuk mengambil salinan daftar karakter.

Penambahan karakter dengan nama duplikat akan ditolak oleh sistem.

## B. Mini-Challenge

### 1. getAverageLevel()

Menghitung rata-rata level seluruh karakter.

Jika daftar karakter kosong, method mengembalikan nilai 0 untuk menghindari pembagian dengan nol.

### 2. findByType(CharacterType type)

Mencari seluruh karakter berdasarkan jenis karakter tertentu dan mengembalikannya dalam bentuk ArrayList.

## C. Fitur Analitik Mandiri

### findStrongest()

Method ini digunakan untuk mencari karakter dengan Attack Power tertinggi.

Proses dilakukan dengan membandingkan nilai Attack Power setiap karakter dalam daftar.

Method mengembalikan salinan objek agar data internal CharacterManager tetap terlindungi.

## D. Object Reference Experiment

Program menguji hubungan reference menggunakan dua variabel objek, yaitu a dan b.

Ketika b diberikan nilai dari a, kedua variabel menunjuk objek yang sama. Oleh karena itu, perubahan atribut melalui b juga memengaruhi objek yang diakses melalui a.

Program juga menggunakan copy constructor untuk menghasilkan objek independen sehingga perubahan pada objek salinan tidak memengaruhi objek asli.

## E. Defensive Copy

Method getAllCharacters() menghasilkan salinan ArrayList beserta objek Character di dalamnya.

Pengujian dilakukan dengan menghapus seluruh isi daftar salinan.

Hasilnya, daftar karakter asli tetap memiliki data yang sama karena tidak menggunakan reference ArrayList yang sama.

---

## Screenshot Output Program

![Character Manager TP5](charactermanager TP5.png)

---

## Struktur Folder

```text
charactermanager/
│
├── CharacterManager/
│   ├── src/
│   │   └── com/
│   │       └── unpri/
│   │           └── charactermanager/
│   │               ├── Main.java
│   │               └── model/
│   │                   ├── Character.java
│   │                   ├── CharacterType.java
│   │                   └── CharacterManager.java
│   │
│   └── out/
│
├── screenshots/
│   └── output-tp5.png
│
└── README.md
```

## Teknologi

- Java
- JDK 17
- Visual Studio Code
- Git
- GitHub
- ArrayList
- Object-Oriented Programming

---

## Identitas Mahasiswa

- Nama: ALga Vancany Yunita Purba
- NIM: 253303621269
- Kelas: 3 PAGI - B
- Program Studi: Sistem Informasi
- Fakultas: Sains dan Teknologi
- Universitas: Universitas Prima Indonesia
- Mata Kuliah: Java Visual
- Kode Mata Kuliah: SIH-6406

## Dokumentasi Analisis TP5

Google Docs:

[(https://docs.google.com/document/d/1w-ZLNuCGWYLtGJEnl95HBE_sf676Owdr9LcjKeZFc3M/edit?usp=sharing)]

---

Character Manager Sprint #2  
Java Visual (SIH-6406)  
UNPRI  
Dosen: Dr. Evta Indra
