package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private ArrayList<Matakuliah> kelas = new ArrayList<Matakuliah>();
    private Scanner input           = new Scanner(System.in);
    private Boolean loopmenu        = true;
    private String pilih            = null;

    public void addMatkul(){
        int size = 0;
        System.out.println("#### Pendataan matakuliah");
        System.out.println("Masukan jumlah matakuliah: ");
        size = input.nextInt();input.nextLine();
        for(int i = 0;i<size;i++){
            System.out.println("#### Pendataan matakuliah");
            System.out.println("masukan kode matakuliah\t:");
            String kode = input.nextLine();
            System.out.println("masukan nama matakuliah\t:");
            String nama = input.nextLine();
            System.out.println("masukan grade matakuliah\t:");
            String grade = input.nextLine();
            System.out.println("masukan jumlah sks \t\t:");
            int sks = input.nextInt();input.nextLine();
            this.kelas.add(new Matakuliah(kode.toUpperCase(),nama.toUpperCase(),grade.substring(0,1).toUpperCase(),sks));
        }
    }
    public void updateGrade(){
        System.out.println("#### Update grade");
        System.out.println("masukan kode matakuliah:");
        String kode = input.nextLine();
        System.out.println("masukan grade matakuliah:");
        String  grade = input.nextLine();
        Boolean ganti = false;
        for(Matakuliah m : kelas){
            if(m.getKode().equals(kode.toUpperCase())){
                System.out.println("************ update");
                System.out.println("** Kode matakuliah \t\t:"+m.getKode());
                System.out.println("** Nama matakuliah \t\t:"+m.getNama());
                System.out.println("** Grade matakuliah (before)\t:"+m.getGrade());
                System.out.println("** Grade matakuliah (after)\t:"+grade.substring(0,1).toUpperCase());
                System.out.println("** sks matakuliah \t\t:"+m.getSks());
                m.setGrade(grade.substring(0,1).toUpperCase());
                ganti = true;
            }
        }
        if(ganti) {
            System.out.println("*** perubahan selesai ***");
        }else{
            System.out.println("*** kode tidak ditemukan ***");
        }
    }
    public void listMatkul(){
        System.out.println("#### List matakuliah");
        for(int i = 0; i<this.kelas.size();i++){
            Matakuliah m = this.kelas.get(i);
            System.out.println((i+1)+"|"+m.getKode()+"|"+m.getNama()+"|"+m.getGrade()+"|"+m.getSks());
        }
        System.out.println("#### oOo  ####");
    }
    public void ipsResult(){
        System.out.println("#### List matakuliah");
        int sks     = 0;
        for(int i = 0; i<this.kelas.size();i++){
            Matakuliah m = this.kelas.get(i);
            System.out.println((i+1)+"|"+m.getKode()+"|"+m.getNama()+"|"+m.getGrade()+"|"+m.getSks());
            sks += m.getSks();
        }
        System.out.println("total SKS\t:"+sks);
        System.out.println("IP\t\t\t:"+this.sumIps());
        System.out.println("#### oOo  ####");
    }
    public float sumIps(){
        int sks = 0;
        int sum = 0;
        for(Matakuliah temp : this.kelas){
            int g = 0;
            switch (temp.getGrade().toUpperCase()){
                case "A": g = 4;break;
                case "B": g = 3;break;
                case "C": g = 2;break;
                case "D": g = 1;break;
                case "E": g = 0;break;
                default:g=0;temp.setGrade("E");
            }
            sks += temp.getSks();
            sum += g * temp.getSks();
        }
        float ips = (float) sum / sks;
        return ips;
    }
    public void mainmenu(){
        do{
            System.out.println("################################");
            System.out.println("Pendataan dan Perhitungan IPS");
            System.out.println("1.Pendataan mata kuliah");
            System.out.println("2.perhitungan IPS");
            System.out.println("3.Update grade");
            System.out.println("4.daftar matakuliah");
            System.out.println("5.Keluar");
            System.out.println("################################");
            System.out.println("Masukan pilihan anda:");
            pilih = input.nextLine();
            switch (pilih){
                case "1":this.addMatkul();loopmenu=true;break;
                case "2":this.ipsResult();loopmenu=true;break;
                case "3":this.updateGrade();loopmenu=true;break;
                case "4":this.listMatkul();loopmenu=true;break;
                case "5":loopmenu=false;break;
                default:loopmenu=false;
            }
        }while(loopmenu);
    }
    public static void main(String[] args) {
	// write your code here
        Main m = new Main();
        m.mainmenu();
    }
}
