# Penjelasan Cara Membangun Aplikasi dari Source Code yang Ada di Repository:

## Persiapan Dokumen Markdown

Untuk mempermudah dalam mengkonversi menjadi file HTML yang terstruktur, penulisan dokumen Markdown perlu mengikuti kaidah sebagai berikut:  

 - Penamaan file tanpa menggunakan spasi, misal ejuklak_FTIS, bukan ejuklak FTIS;  
 - Simpan file dengan ekstensi md  
 - Tulis dokumen secara terstruktur. Lakukan pemformatan dengan memanfaatkan fitur *Style and Formatting*:  
   - Bab sebagai Heading 1;  
   - Subbab sebagai Heading 2;  
   - Subsubbab sebagai Heading 3;   

## Mengkonversi Dokumen

Proses mengkonversi dokumen dapat dilakukan dengan menggunakan Pandoc. Pandoc merupakan suatu *tool* untuk mengkonversi antar dokumen, salah satunya dari file Markdown ke file HTML. Anda perlu menginstal Pandoc pada sistem komputer Anda. Silahkan unduh (download) dari [](https://github.com/jgm/pandoc/releases) untuk sistem operasi berbasis Windows. Pandoc terbaru adalah versi 1.13.2 –rilis pada 20/12/2014.  

Proses mengkonversi file pada Pandoc menggunakan perintah (*command line*). Untuk dokumentasi lengkap penggunaan Pandoc dapat dilihat melalui websitenya [](http://pandoc.org/getting-started.html#step-6-converting-a-file).  

Langkah-langkah mengkonversi file Markdown ke HTML:  

1. Pertama masuk terlebih dahulu ke dalam direktori tempat file Markdown yang akan dikonversi disimpan. Pada contoh di bawah, file markdown terdapat pada direktori Documents/ejuklak.
  ![Masuk directory](images/Manual_Build_1.png "Masuk directory")  
2. Setelah masuk ke dalam direktori file Markdown, langkah selanjutnya adalah melakukan konversi terhadap file Markdown tersebut. Perintah yang digunakan adalah sebagai berikut.  
   ```
    pandoc ejuklak_FTIS.md -f markdown -t html -s -o ejuklak_FTIS.html
   ```
![Konversi file](images/Manual_Build_2.png "Konversi file")  
Nama file **ejuklak&#95;FTIS.md** memberi tahu Pandoc file mana yang akan dikonversi. Keterangan beberapa *command*:  
  - **–s** menandakan bahwa file yang akan dibuat bersifat *“standalone”*, dengan *header* dan *footer*, tidak hanya fragment saja. 
  - **–o ejuklak&#95;FTIS.html** berfungsi untuk menyimpan output pada file ejuklak.html. 
  - **–f markdown** dan **–t html** digunakan karena kita akan mengkonversi dari file markdown ke dalam file html.
3. File HTML yang telah jadi disimpan dalam direktori eJuklakWeb/
4. File HTML yang telah jadi dimodifikasi dengan menambahkan link menuju file css yang akan digunakan.  
   ```
    <link rel="stylesheet" type="text/css" href="css/style.css">
   ```

## Pembuatan CSS

CSS dibuat menggunakan MarkdownPad 2. MarkdownPad 2 merupakan sebuah editor untuk file markdown pada sistem operasi Windows. Aplikasi ini mempunyai dua versi, gratis dan pro (berbayar). Berikut beberapa fitur-fitur dari MarkdownPad 2 ini:  
 - Instant HTML Preview
 - Print HTML
 - Print Markdown
 - HTML export
 - Custom CSS
 - Spell check
 - Custom CSS  

MarkdownPad 2 dapat mengkonversi file Markdown ke file HTML. Namun dari hasil konversi yang berupa file HTML, yang digunakan hanyalah file CSS saja. Konten dari juklaknya tetap menggunakan hasil konversi menggunakan Pandoc. Mengapa? Karena pada Pandoc, setiap *heading* yang ada memiliki ID masing-masing sesuai dengan isi dari heading tersebut dimana pada MarkdownPad 2 tidak dihasilkan seperti itu. Hal ini akan memudahkan kita dalam membuat daftar isi pada aplikasi.
Untuk lebih jelasnya,langkah-langkah pembuatan file CSS terdapat pada keterangan berikut ini:  

1. Buka terlebih dahulu file Markdown yang akan digunakan. Setelah itu klik menu Tools. Lalu pilih menu Preview Markdown in Browser. Kita dapat juga langsung menekan tombol F6.
  ![Preview markdown](images/Manual_Build_3.png "Preview markdown")
2. Selanjutnya file HTML dari markdown akan tampil pada browser.
  ![Markdown pada browser](images/Manual_Build_4.png "Markdown pada browser")
3. Simpan halaman HTML tersebut.
  ![Simpan halaman html](images/Manual_Build_5.png "Simpan halaman html")
4. Buka file HTML tersebut menggunakan teks editor(Notepad++). Setelah itu ambil seluruh kode CSS yang ada pada file HTML tersebut, pisahkan dari file HTML  kemudian simpan dengan nama style.css. File CSS yang telah jadi disimpan dalam directori eJuklakWeb/css.
  ![Ambil CSS](images/Manual Build_6.png "Ambil CSS")
  ![Simpan jadi style.css](images/Manual_Build_7.png "Simpan jadi style.css")
  File CSS yang telah ada dapat dimodifikasi lagi untuk mempercantik tampilan dari konten ejuklak. Disini yang ditambahkan adalah *style* untuk tabel berupa border dan warna *header* tabel.
  ![modifikasi css](images/Manual_Build_8.png "modifikasi css")

## Melakukan *Import* Projek

1. IDE yang kami gunakan adalah eclipse, karena kami menggunakan github maka project harus kami *import*.
2. Pilih *workspace* terlebih dahulu
  ![import projek](images/Manual_Build_9.png "import projek")  
3. Setelah masuk ke dalam eclipse, pilih File lalu Import.
  ![import projek](images/Manual_Build_10.png "import projek")  
4. Pilih Projects from Git lalu klik Next
  ![import projek](images/Manual_Build_11.png "import projek")  
5. Pilih Clone URl lalu klik Next
  ![import projek](images/Manual_Build_12.png "import projek")  
6. Masukkan URl repositori Github yang akan di*clone* ke field URl.
  ![import projek](images/Manual_Build_13.png "import projek")
7. Pilih *branch* git yang akan digunakan, pada manual ini kita gunakan *branch* master.
  [import projek](images/Manual_Build_14.png "import projek")  
8. Langkah selanjutnya, kita harus memilih *local directory* untuk menyimpan projek kita.
  [import projek](images/Manual_Build_15.png "import projek")  
9. Pilihlah menu Import existing project karena kita akan melakukan *import* dari projek yang sudah dibuat sebelumnya. Hal tersebut dilakukan agar seluruh project yang ada pada repositori git tersebut dapat dibuka dengan eclipse.
  [import projek](images/Manual_Build_16.png "import projek")  
10. Setelah itu pilih projek-projek yang akan digunakan. Setelah selesai, klik Finish.
  [import projek](images/Manual_Build_17.png "import projek")

## Pembuatan Aplikasi

Berikut langkah-langkahnya:

1. Buatlah project android dengan target SDK API 19.
  ![build aplikasi](images/Manual_Build_18.png "build aplikasi")
  ![build aplikasi](images/Manual_Build_19.png "build aplikasi")  
2. File markdown yang sudah dikonversi menjadi file HTML diletakkan ke dalam folder asset dalam project android.
  ![build aplikasi](images/Manual_Build_20.png "build aplikasi")  
3. File tersebut akan dibaca menggunakan AssetManager dan di-parse menggunakan Jsoup untuk mendapatkan header-header HTML yang nanti akan digunakan sebagai daftar isi.  
4. HTML akan ditampilkan menggunakan Webview yang berada dalam kelas ViewFragment.  
5. Kelas ViewFragment merupakan Fragment yang menampilkan WebView dalam MainActivity.  
6. WebView yang digunakan dapat melakukan zoom dan orientation.  
7. Terdapat pula daftar isi pada MainActivity yang dibuat menggunakan NavigationDrawer dan dapat menuju ke header HTML jika disentuh.
8. Buat emulator android untuk menjalankan aplikasi melalui Android Virtual Device Manager.
  ![build aplikasi](images/Manual_Build_21.png "build aplikasi")  
9. Jika belum ada virtual device, maka harus dibuat terlebih dahulu.
  ![build aplikasi](images/Manual_Build_22.png "build aplikasi")  
10. Buat emulator sesuai dengan target SDK yang sudah ditentukan.
  ![build aplikasi](images/Manual_Build_23.png "build aplikasi")  
11. Jalankan aplikasi tersebut dengan cara klik kanan lalu Run as lalu Android Application
  ![build aplikasi](images/Manual_Build_24.png "build aplikasi")  
12. File APK terbuat secara otomatis saat menjalankan aplikasi menggunakan android emulator dari android SDK. File APK tersebut berada pada folder bin.
  ![build aplikasi](images/Manual_Build_25.png "build aplikasi")
