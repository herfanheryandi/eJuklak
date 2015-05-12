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

Proses mengkonversi dokumen dapat dilakukan dengan menggunakan Pandoc. Pandoc merupakan suatu tool untuk mengkonversi antar dokumen, salah satunya dari file Markdown ke file HTML. Anda perlu menginstal Pandoc pada sistem komputer Anda. Silahkan unduh (download) dari https://github.com/jgm/pandoc/releases untuk sistem operasi berbasis Windows. Pandoc terbaru adalah versi 1.13.2 –rilis pada 20/12/2014.  

Proses mengkonversi file pada Pandoc menggunakan perintah (*command line*). Untuk dokumentasi lengkap penggunaan Pandoc dapat dilihat melalui websitenya (http://pandoc.org/getting-started.html#step-6-converting-a-file).  

Langkah-langkah mengkonversi file Markdown ke HTML:  

1. Untuk mengkonversi dari file Markdown ke HTML, yang pertama kita lakukan adalah masuk terlebih dahulu ke dalam direktori tempat file Markdown yang akan dikonversi disimpan. Pada contoh di bawah, file markdown terdapat pada direktori Documents/ejuklak.  
![](images/Lampiran_BAB2_1.png "Peta dan Prasyarat Mata Kuliah Program Studi Matematika")  
2. Setelah masuk ke dalam direktori file Markdown, langkah selanjutnya adalah melakukan konversi terhadap file Markdown tersebut. Perintah yang digunakan adalah sebagai berikut.  

    > pandoc ejuklak_FTIS.md -f markdown -t html -s -o ejuklak_FTIS.html
    
    ![](images/Lampiran_BAB2_1.png "Peta dan Prasyarat Mata Kuliah Program Studi Matematika")
    
    Nama file ejuklak.md memberi tahu Pandoc file mana yang akan diconvert. –o ejuklak.html berfungsi untuk menyimpan output pada file ejuklak.html. –f markdown dan –t html digunakan karena kita akan mengkonversi dari file markdown ke dalam file html.
3. File HTML yang telah jadi disimpan dalam direktori eJuklakWeb/
4. Untuk pembuatan CSS, kita dapat menggunakan MarkdownPad 2. MarkdownPad 2 merupakan sebuah editor untuk file markdown pada sistem operasi Windows. Aplikasi ini mempunyai dua versi, gratis dan pro (berbayar). Berikut beberapa fitur-fitur dari MarkdownPad 2 ini:  
    - Instant HTML Preview
    - Print HTML
    - Print Markdown
    - HTML export
    - Custom CSS
    - Spell check
    - Custom CSS  

    Dengan MarkdownPad 2, kita juga dapat mengkonversi file Markdown ke file HTML. Namun dari hasil konversi yang berupa file HTML, yang digunakan hanyalah file CSS saja. Konten dari juklaknya tetap menggunakan hasil konversi menggunakan Pandoc. Mengapa? Karena pada Pandoc, setiap *heading* yang ada memiliki ID masing-masing sesuai dengan isi dari heading tersebut dimana pada MarkdownPad 2 tidak dihasilkan seperti itu. Hal ini akan memudahkan kita dalam membuat daftar isi pada aplikasi.
Untuk lebih jelasnya,langkah-langkah pembuatan file CSS terdapat pada gambar berikut ini.  

  1. Buka terlebih dahulu file Markdown yang akan digunakan. Setelah itu klik menu Tools. Lalu pilih menu Preview Markdown in Browser. Kita dapat juga langsung menekan tombol F6.
  2. 


