package com.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import com.example.LibraryService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ArrayList<Book>  bookArrayList = new ArrayList<>();
        ArrayList<Jornal> jornalArrayList = new ArrayList<>();
        ArrayList<Magazine> magazineArrayList = new ArrayList<>();


        //book objects
        Book book1 = new Book();
        book1.setId(101);
        book1.setTitle("Clean Code");
        book1.setAuthor("Robert C. Martin");
        book1.setDatePublish(LocalDate.of(2008, 8, 1));
        book1.setEdition("1ª edição");

        bookArrayList.add(book1);


        Book book2 = new Book();
        book2.setId(102);
        book2.setTitle("Effective Java");
        book2.setAuthor("Joshua Bloch");
        book2.setDatePublish(LocalDate.of(2018, 1, 6));
        book2.setEdition("3ª edição");

        bookArrayList.add(book2);



        Book book3 = new Book();
        book3.setId(103);
        book3.setTitle("Java: The Complete Reference");
        book3.setAuthor("Herbert Schildt");
        book3.setDatePublish(LocalDate.of(2019, 4, 12));
        book3.setEdition("11ª edição");

        bookArrayList.add(book3);

        //LibraryService Usage

        System.out.println("\n Catálogo inicial:");
        bookArrayList.forEach(b -> System.out.println(b.getTitle() + " - disponível: " + b.isAvailable()));

        // --- BUSCAR LIVROS POR AUTOR ---
        System.out.println("\n Livros do autor 'Joshua Bloch':");
        List<Book> livrosDoAutor = LibraryService.findBooksByAuthor(bookArrayList, "Joshua Bloch");
        livrosDoAutor.forEach(b -> System.out.println(b.getTitle()));

        // --- CONTAR LIVROS DISPONÍVEIS ---
        long disponiveis = LibraryService.countAvailableBooks(bookArrayList);
        System.out.println("\n Quantidade de livros disponíveis: " + disponiveis);

        // --- EMPRESTAR LIVRO (imutável) ---
        System.out.println("\n Emprestando o livro de ID 101 (Clean Code)...");
        List<Book> afterLend = LibraryService.lendBookById(bookArrayList, 101);

        System.out.println("\n Após o empréstimo:");
        afterLend.forEach(b -> System.out.println(b.getId() +""+ b.getTitle() + " - disponível: " + b.isAvailable()));

        // --- DEVOLVER LIVRO (imutável) ---
        System.out.println("\n Devolvendo o livro de ID 101 (Clean Code)...");
        List<Book> afterReturn = LibraryService.returnBookById(afterLend, 101);

        System.out.println("\n Após a devolução:");
        afterReturn.forEach(b -> System.out.println(b.getTitle() + " - disponível: " + b.isAvailable()));

        // --- CONTAR DISPONIBILIDADE FINAL ---
        long finalDisponiveis = LibraryService.countAvailableBooks((ArrayList<Book>) afterReturn);
        System.out.println("\n Livros disponíveis no final: " + finalDisponiveis);


/*
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
*/



    }
}