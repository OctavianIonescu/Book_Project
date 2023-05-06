package com.book.controllers;
import com.book.services.*;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.book.models.*;
import com.book.daos.*;

import java.io.IOException;
import java.util.*;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



/**
* Controller class
* @Controller
* @author Octavian Ionescu
*/
@Controller
public class MyController {
    private BookService bookService = new BookServiceImpl(new BookDAOImpl());
    HttpSession userSession;
    User user;
    Basket basket;



    @RequestMapping(value="/", method={RequestMethod.GET,RequestMethod.POST})
    public String home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userSession = request.getSession(true);
        Map<Integer, Book> bookList;
        if(userSession.getAttribute("bookList") == null) {
            bookList = bookService.mapIdToBooks(bookService.listAllBooks());
            System.out.println(bookList);
            userSession.setAttribute("bookList", bookList);
        }
        
        if(request.getParameter("search") != null) {
            String bookName = request.getParameter("book_search").toString();
            Map<Integer, Book> searchBookList = bookService.mapIdToBooks(bookService.findAllBooksByName(bookName));
            request.setAttribute("searchBookList", searchBookList);
            
        }
        
        if(request.getParameter("add_to_cart") != null) {
            if(userSession.getAttribute("user") != null || userSession.getAttribute("basket") != null){
                int bookId = Integer.parseInt(request.getParameter("id"));
                bookList = (HashMap<Integer, Book>) request.getSession().getAttribute("bookList");
                Book selected = bookList.get(bookId);
                basket = (Basket) userSession.getAttribute("basket");
                basket.add(selected);
                request.getSession().setAttribute("basket", basket);
                System.out.println("ADDED\n\n\n\n");
                System.out.println(basket.getUser().getU_ID());
                System.out.println(basket.getTotalPrice());
            }else if(userSession.getAttribute("user") == null){
                return "redirect:/login";
            } 
        }
        return "index";
    }



    @RequestMapping(value="/login", method={RequestMethod.GET,RequestMethod.POST})
    public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        System.out.println("loggedin" + user);
        if(request.getParameter("login") != null) {
            String email = (String) request.getParameter("user");
            String pass = (String) request.getParameter("pass");
            User user = bookService.userLogin(email, pass);
            if(user != null) {
                HttpSession userSession = request.getSession(true);
                basket = new Basket(user);
                userSession.setAttribute("user", user);
                userSession.setAttribute("basket", basket);
                System.out.println("loggedin" + user);
                return "redirect:/";
            } else {
                return "login";
            }
        }else return "login";
    }



    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userSession = request.getSession(true);
        if(userSession.getAttribute("user") == null) {
            return "index";
        } else {
            userSession.invalidate();
            System.out.println("loggedout");
            return "logout";
        }
    }



    @RequestMapping(value="/co", method={RequestMethod.GET,RequestMethod.POST})
    public String checkOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userSession = request.getSession(true);
        basket = (Basket) userSession.getAttribute("basket");
        if(request.getParameter("remove_from_cart") != null) {
            int bookId = Integer.parseInt(request.getParameter("isbn"));
            Map<Book, Integer> basketBooks = basket.getBasket();
            System.out.println(basketBooks + "\n\n\n\n");
            for(Map.Entry<Book, Integer> book: basketBooks.entrySet()) { 
                if(book.getKey().getId() == bookId) {
                    basket.remove(book.getKey());
                }
            }
            userSession.setAttribute("basket", basket);
            System.out.println("DELETED\n\n\n\n");
        }
        
        if(request.getParameter("pay") != null){
            user = (User) userSession.getAttribute("user"); 
            if(user != null) {
                bookService.placeOrder(basket, user);
                userSession.getAttribute("basket");
                userSession.setAttribute("basket", new Basket(user));
                return "order_placed";
            }
            else return "login";
            
        }    
        return "check_out";
        
    }
    
    
    
    @RequestMapping(value="/reg", method={RequestMethod.GET,RequestMethod.POST})
    public String reg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
        userSession = request.getSession(true);
        if(request.getParameter("register") != null) {
            String firstName = (String) request.getParameter("firstName");
            String lastName = (String) request.getParameter("lastName");
            String address = (String) request.getParameter("address");
            String pass = (String) request.getParameter("pass");
            String email = (String) request.getParameter("email");
            // register user
            User user1 = new User(firstName, lastName, address, email, pass);
            int userRegistered = bookService.addUser(user1);
            System.out.println(userRegistered);
            if(userRegistered != 0) {
                return "redirect:/login";
            } else {
                return "register";
            }
        } else return "register";
    }



    @GetMapping("/pd")
    public String details(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        userSession = request.getSession(true);
        User user = (User) userSession.getAttribute("user");
        System.out.println(user.getU_ID());
        List<Order> orderList = bookService.listAllOrdersByUser(user);
        System.out.println("orders list " + orderList.size());
        userSession.setAttribute("orderList", orderList);
        return "personal_details";
    }
    


    @RequestMapping(value="/ch", method={RequestMethod.GET,RequestMethod.POST})
    public String ch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
        userSession = request.getSession(true);
        User user = (User) userSession.getAttribute("user");
        if(request.getParameter("saveChanges") != null) {
            String firstName = (String) request.getParameter("firstName");
            System.out.println(firstName);
            if(firstName != ""){
                bookService.updateUserFirstNameByUser(user, firstName);
            }
            String lastName = (String) request.getParameter("lastName");
            System.out.println(lastName);
            if(lastName != ""){
                bookService.updateUserLastNameByUser(user, lastName);
            }
            String address = (String) request.getParameter("address");
            System.out.println(address);
            if(address != ""){
                bookService.updateUserAddressByUser(user, address);
            }
            String pass = (String) request.getParameter("pass");
            System.out.println(pass);
            if(pass != ""){
                bookService.updateUserPasswordByUser(user, pass);
            }
            String email = (String) request.getParameter("email");
            System.out.println(email);
            if(email != ""){
                bookService.updateUserEmailByUser(user, email);
            }
            return "personal_details";
        } else return "change_details";
    }
}

