# Laporan Tim Kami sebagai Auditor

---

## Tim Auditor
- Relasi komponen dalam kode masih kurang terorganisasi karena seluruh komponen disimpan dalam satu `List<IKomponen>`.
Sebaiknya, setiap jenis relasi dipisahkan ke dalam variabel yang lebih spesifik agar arsitektur lebih jelas.
- Beberapa `abstract method` yang didefinisikan pada `interface` belum sepenuhnya diimplementasikan pada kelas turunan.
Hal ini dapat menyebabkan inkonsistensi perilaku antar komponen.
- Terdapat redundansi kode pada kelas-kelas komponen karena belum adanya `inheritance` yang menyatukan atribut dan method umum.
