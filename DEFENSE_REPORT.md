# Laporan Tim Kami sebagai Auditee

## Tim Auditor
- Auditor menemukan ketidaksesuaian dalam penentuan jenis relasi antar `class`.
Komponen `peripheral` yang seharusnya memiliki relasi agregasi justru direpresentasikan sebagai asosiasi dalam diagram.

## Tim Auditee
- Menurut tim kami, penggunaan relasi asosiasi untuk `peripheral` sudah merupakan keputusan desain yang paling tepat.
Hal ini karena peripheral tidak sepenuhnya dimiliki oleh objek PC, melainkan hanya berinteraksi dengannya selama proses penggunaan.
Dengan demikian, hubungan asosiasi lebih merepresentasikan hubungan dunia nyata dibandingkan agregasi.
