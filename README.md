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
