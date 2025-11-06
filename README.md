# PC Builder Tycoon - Core Engine v1.0

## Tim Pengembang
- **Faris Akmal Soehartono** (3124600101)
- **Ashlihatul Sotya Mahendra** (3124600110)

## Dosen Pembimbing
- **Grezio Arifiyan Primajaya S.Kom, M.Kom**

---

## Deskripsi

**PC Builder Tycoon - Core Engine v1.0** adalah simulasi sistem perakitan PC berbasis **Object-Oriented Programming (OOP)**.  
Proyek ini dirancang untuk mendemonstrasikan penerapan konsep `interface`, `abstract class`, komposisi, agregasi, dan asosiasi dalam arsitektur perangkat lunak berorientasi objek.

---

## Arsitektur

Arsitektur sistem ini menggunakan **interface `IKomponen`** sebagai kontrak bagi semua komponen PC, sehingga setiap bagian (seperti CPU, RAM, penyimpanan, dan periferal) dapat diimplementasikan tanpa mengubah struktur class `PC` (**Open-Closed Principle**).  

Relasi:
![UML Class Diagram](images/UML%20Class%20Diagram.png)
- **Komposisi** digunakan untuk komponen inti (`motherboard`, `cpu`, `ram`) karena ketiganya wajib ada dalam sebuah PC.
- **Agregasi** digunakan untuk daftar penyimpanan (`List<IKomponen> penyimpanan`), yang dapat ditambahkan atau dihapus tanpa memengaruhi objek `PC`.
- **Asosiasi** digunakan untuk daftar periferal (`List<IKomponen> peripheral`), yang merepresentasikan hubungan eksternal antara PC dan perangkat input/output.

Untuk menghindari redundansi kode, dibuat class induk **`BaseComponent`** yang menyimpan atribut umum (`price`, `nama`, `brand`) dan mengimplementasikan `IKomponen`. Semua komponen seperti `CPU`, `RAM`, `SSD`, dan `Motherboard` mewarisi class ini.

---

## Refactoring: Move Method (generateReport)

**Pada kode awal**, method `generateReport(PC pc)` berada di dalam kelas PCReportGenerator.
Namun, method ini terlalu banyak mengakses atribut internal dari objek `PC` (misalnya `pc.getCPU()`, `pc.getMotherboard()`, dan `pc.getRamSticks()`).
Hal ini menandakan pelanggaran prinsip Encapsulation dan Feature Envy Smell, karena kelas PCReportGenerator terlalu “cemburu” terhadap data milik `PC`.

**Setelah refactoring**, yaitu pemindahan method `generateReport` jadi milik `PC`, `PC` kini memiliki tanggung jawab penuh untuk menampilkan laporan konfigurasi miliknya sendiri dan kelas `PCReportGenerator` hanya bertindak sebagai delegasi.

---

## DEBRIEFING & REFLEKSI

### 1. Momen "Aha!" Terbesar  
Momen paling berkesan adalah saat kami sadar pentingnya `abstract class` setelah mengalami *redundansi kode* yang parah.  
Awalnya kami hanya memakai `interface IKomponen` karena terlihat simpel dan fleksibel. Tapi ternyata setiap class (`CPU`, `RAM`, `Motherboard`, dll) harus menulis ulang field `price`, `nama`, `brand`, beserta `getter-setter` yang sama persis, jelas melanggar **DRY (Don’t Repeat Yourself)** principle.  

Saat refactoring, kami akhirnya sadar:  
> “Oh, makanya ada *abstract class!*”

Setelah memakai `BaseComponent`, semua *common implementation* tersimpan di satu tempat, sementara *child class* tinggal `extends` saja — hasilnya kode langsung bersih dan konsisten.  
Di sini kami memahami bahwa interface dan abstract class bukan kompetisi, tapi kolaborasi:  
- `interface` untuk mendefinisikan kontrak (*what to do*),  
- `abstract class` untuk menyediakan implementasi dasar (*how to do it*).  

---

### 2. Kelemahan Terbesar Tim  
Kelemahan terbesar kami adalah kesulitan menghindari code smell.  
Awalnya kami terlalu fokus membuat kode yang berjalan, bukan yang bersih. Akibatnya:  
- Duplikasi kode di mana-mana  
- Method “aneh” seperti `activatePenyimpanan()` yang harus dipanggil manual  
- Tidak ada validasi input  
- Method redundan seperti `getTotalPrice()` yang hanya jadi *wrapper*  

Selain itu, kami juga bingung menentukan relasi antar objek, mana komposisi, agregasi, atau asosiasi.  
Setelah diskusi dan riset, kami akhirnya memahami:  
- **Komposisi**, untuk komponen inti (hubungan kuat, *strong ownership*)  
- **Agregasi**, untuk penyimpanan (hubungan lemah, *shared ownership*)  
- **Asosiasi**, untuk periferal (hanya *berinteraksi*, tidak dimiliki)  

Tantangan lain adalah membuat UML Diagram yang akurat. Kami sempat mengira tinggal *export* dari tool, tapi ternyata perlu memahami notasi: garis composition, aggregation, association, dependency, dan realization. Tools seperti **PlantUML** dan **Draw.io** juga punya gaya berbeda, jadi salah garis bisa berarti salah konsep.

**Cara kami meminimalisir code smell:**
- Melakukan code review antar anggota tim  
- Melakukan refactoring bertahap dan berkelanjutan  
- Riset best practices OOP dan menerapkan prinsip SOLID
- Gunakan UML untuk memvalidasi desain  
- Fokus pada Single Responsibility & DRY Principle

**Pelajaran:**
> 1. Clean code bukan bonus, tapi kebutuhan utama.  
> 2. Code smell adalah technical debt yang akan jadi beban besar nanti.  
> 3. Skill mendeteksi dan mencegah code smell sangat penting, terutama untuk proyek nyata dan kerja tim di industri.  

---

### 3. Skill Baru Paling Berharga  
Praktikum ini bukan hanya soal sintaks, tapi soal pola pikir rekayasa perangkat lunak.  
Skill paling berharga yang kami dapat:  

1. **Trial–Error–Refactor Mindset**  
   Belajar bahwa kode bagus itu tidak lahir sekali jadi.  
   Proses kami:  
   Hanya menerapkan interface -> redundansi -> refactor pakai abstract class -> perbaiki relasi -> buat UML -> deteksi code smell -> refactor ulang.

2. **Memahami "Why" di Balik Desain**  
   Sekarang kami bisa menganalisis alasan desain:  
   Kenapa pakai `interface`, kenapa `composition`, kenapa perlu `abstract class`.  

3. **UML sebagai Communication Tool**  
   UML bukan sekadar gambar — tapi alat komunikasi, dokumentasi, dan validasi desain.  
   Kalau UML-nya membingungkan, berarti desainnya juga perlu diperbaiki.  

4. **Mendeteksi dan Menghapus Code Smell**  
   Sekarang kami lebih sensitif terhadap:  
   - *Duplicated code*  
   - *Long methods*  
   - *Bad naming*  
   - *Tight coupling*  

5. **Perubahan Mindset Developer**  
   - Dari *"asal jalan"* ke *"harus maintainable"*  
   - Dari *"asal implement"* ke *"design for change"*  
   - Dari *"solo coding"* ke *"engineering as teamwork"*  
