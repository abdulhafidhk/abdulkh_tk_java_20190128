package com.company;

public class Matakuliah {
        private String kode     = null;
        private String nama     = null;
        private String grade    = null;
        private int sks         = 0;

        public Matakuliah(String k,String n,String g,int s){
            this.kode   = k;
            this.nama   = n;
            this.grade  = g;
            this.sks    = s;
        }
        public String getKode() {
            return kode;
        }

        public void setKode(String kode) {
            this.kode = kode;
        }

        public String getNama() {
            return nama;
        }

        public void setNama(String nama) {
            this.nama = nama;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }

        public int getSks() {
            return sks;
        }

        public void setSks(int sks) {
            this.sks = sks;
        }

}
