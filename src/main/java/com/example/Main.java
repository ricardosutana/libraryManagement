package com.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ArrayList<Book>  bookArrayList = new ArrayList<>();
        ArrayList<Jornal> jornalArrayList = new ArrayList<>();
        ArrayList<Magazine> magazineArrayList = new ArrayList<>();

        HashSet<Book> bookHashSet =new HashSet<>();


        //book objects
        Book book1 = new Book();
        book1.setId(101);
        book1.setTitle("Clean Code");
        book1.setAuthor("Robert C. Martin");
        book1.setDatePublish(LocalDate.of(2008, 8, 1));
        book1.setEdition("1ª edição");

        bookArrayList.add(book1);

        bookHashSet.add(book1);
        System.out.println("tamanho array: "+bookArrayList.size());

        Book book2 = new Book();
        book2.setId(102);
        book2.setTitle("Effective Java");
        book2.setAuthor("Joshua Bloch");
        book2.setDatePublish(LocalDate.of(2018, 1, 6));
        book2.setEdition("3ª edição");

        bookArrayList.add(book2);

        bookHashSet.add(book2);
        System.out.println("tamanho array: "+bookArrayList.size());

        Book book3 = new Book();
        book3.setId(103);
        book3.setTitle("Java: The Complete Reference");
        book3.setAuthor("Herbert Schildt");
        book3.setDatePublish(LocalDate.of(2019, 4, 12));
        book3.setEdition("11ª edição");

        bookArrayList.add(book3);

        bookHashSet.add(book3);
        System.out.println("tamanho array: "+bookArrayList.size());

        // Journal objects
        Jornal jornal1 = new Jornal();
        jornal1.setId(201);
        jornal1.setTitle("O Globo");
        jornal1.setAuthor("Redação O Globo");
        jornal1.setDatePublish(LocalDate.of(2025, 9, 18));
        jornal1.setChiefEditor("Miriam Leitão");

        jornalArrayList.add(jornal1);



        Jornal jornal2 = new Jornal();
        jornal2.setId(202);
        jornal2.setTitle("Folha de S.Paulo");
        jornal2.setAuthor("Equipe Folha");
        jornal2.setDatePublish(LocalDate.of(2025, 9, 17));
        jornal2.setChiefEditor("Sérgio Dávila");

        jornalArrayList.add(jornal2);

        Jornal jornal3 = new Jornal();
        jornal3.setId(203);
        jornal3.setTitle("Estado de Minas");
        jornal3.setAuthor("Redação EM");
        jornal3.setDatePublish(LocalDate.of(2025, 9, 16));
        jornal3.setChiefEditor("Carlos Marcelo");

        jornalArrayList.add(jornal3);

        //magazine objects
        Magazine mag1 = new Magazine();
        mag1.setId(301);
        mag1.setTitle("Veja");
        mag1.setAuthor("Editora Abril");
        mag1.setDatePublish(LocalDate.of(2025, 9, 10));
        mag1.setPeriodicity("Semanal");

        magazineArrayList.add(mag1);


        Magazine mag2 = new Magazine();
        mag2.setId(302);
        mag2.setTitle("Superinteressante");
        mag2.setAuthor("Grupo Abril");
        mag2.setDatePublish(LocalDate.of(2025, 8, 25));
        mag2.setPeriodicity("Mensal");

        magazineArrayList.add(mag2);


        Magazine mag3 = new Magazine();
        mag3.setId(303);
        mag3.setTitle("National Geographic Brasil");
        mag3.setAuthor("NG Brasil");
        mag3.setDatePublish(LocalDate.of(2025, 9, 1));
        mag3.setPeriodicity("Mensal");

        magazineArrayList.add(mag3);

        Book book4 = new Book();
        book1.setId(104);
        book1.setTitle(""); //NullArgument
        book1.setAuthor("Robert C. Martin");
        book1.setDatePublish(LocalDate.of(2008, 8, 1));
        book1.setEdition("1ª edição");



    }
}