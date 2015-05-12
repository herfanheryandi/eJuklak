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
![](.../res/manual build/Manual Build 01.png "Masuk directory")  
2. Setelah masuk ke dalam direktori file Markdown, langkah selanjutnya adalah melakukan konversi terhadap file Markdown tersebut. Perintah yang digunakan adalah sebagai berikut.  
   ```
    pandoc ejuklak_FTIS.md -f markdown -t html -s -o ejuklak_FTIS.html
   ```
![](.../res/manual build/Manual Build 02.png "Konversi file")  
Nama file **ejuklak&#95;FTIS.md** memberi tahu Pandoc file mana yang akan dikonversi. Keterangan beberapa *command*:  
  - **–s** menandakan bahwa file yang akan dibuat bersifat *“standalone”*, dengan *header* dan *footer*, tidak hanya fragment saja. 
  - **–o ejuklak&#95;FTIS.html** berfungsi untuk menyimpan output pada file ejuklak.html. 
  - **–f markdown** dan **–t html** digunakan karena kita akan mengkonversi dari file markdown ke dalam file html.
3. File HTML yang telah jadi disimpan dalam direktori eJuklakWeb/
4. File HTML yang telah jadi dimodifikasi dengan menambahkan link menuju file css yang akan digunakan.  
   ```
    <link rel="stylesheet" type="text/css" href="css/style.css">
   ```

##Pembuatan CSS

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
![](.../res/manual build/Manual Build 03.png "Preview markdown")
2. Selanjutnya file HTML dari markdown akan tampil pada browser. 
![](.../res/manual build/Manual Build 04.png "Markdown pada browser")
3. Simpan halaman HTML tersebut.  
![](.../res/manual build/Manual Build 05.png "Simpan halaman html")
4. Buka file HTML tersebut menggunakan teks editor(Notepad++). Setelah itu ambil seluruh kode CSS yang ada pada file HTML tersebut, pisahkan dari file HTML  kemudian simpan dengan nama style.css. File CSS yang telah jadi disimpan dalam directori eJuklakWeb/css.  
![](.../res/manual build/Manual Build 06.png "Ambil CSS")  
![](.../res/manual build/Manual Build 07.png "Simpan jadi style.css")
File CSS yang telah ada dapat dimodifikasi lagi untuk mempercantik tampilan dari konten ejuklak. Disini yang ditambahkan adalah *style* untuk tabel berupa border dan warna *header* tabel.  
![](.../res/manual build/Manual Build 08.png "modifikasi css")

##Pembuatan Aplikasi

Berikut langkah-langkah pembuatan:

1. Bukalah Eclipse LUNA sebagai editor. Lalu buat project android dengan target SDK API 19.  
![](.../res/manual build/Manual Build 09.png "Buat project")  
![](.../res/manual build/Manual Build 10.png "Target SDK")  
2. File markdown yang sudah dikonversi menjadi file HTML diletakkan ke dalam folder asset dalam project android.  
![](.../res/manual build/Manual Build 11.png "Asset")  
3. File tersebut akan dibaca menggunakan AssetManager dan di-parse menggunakan Jsoup untuk mendapatkan header-header HTML yang nanti akan digunakan sebagai daftar isi.  
4. HTML akan ditampilkan menggunakan Webview yang berada dalam kelas ViewFragment.  
5. Kelas ViewFragment merupakan Fragment yang menampilkan WebView dalam MainActivity.  
6. WebView yang digunakan dapat melakukan zoom dan orientation.  
7. Daftar isi pada MainActivity dibuat menggunakan NavigationDrawer dan dapat menuju ke header HTML jika disentuh.
8. File APK terbuat secara otomatis saat menjalankan aplikasi menggunakan android emulator dari android SDK. File APK tersebut berada pada folder bin.
![](.../res/manual build/Manual Build 12.png "apk pada bin")
