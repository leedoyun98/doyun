package doyun.lee.api.pay.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


import doyun.lee.api.brd.domain.Board;
import doyun.lee.api.cart.domain.Cart;
import doyun.lee.api.prd.domain.Product;
import doyun.lee.api.rcv.domain.Receiver;
import doyun.lee.api.usr.domain.UserVo;
import lombok.Getter;

@Entity @Getter
public class Payment {
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name="pay_no") private long payNo;
   @Column(name="pay_price") private String payPrice;
   @Column(name="pay_amount") private long payAmount;
   @Column(name="dvr_fee") private String dvrFee;
   @Column(name="pay_date") private String payDate;
   @Column(name="pay_state") private String payState;
   
   @ManyToOne
   @JoinColumn(name="usr_no")
   private UserVo user;
   
   @ManyToOne
   @JoinColumn(name="prd_no")
   private Product product;
   
   @OneToMany(mappedBy="payment")
   private List<Receiver> receivers = new ArrayList<>();
   
   @OneToMany(mappedBy="payment")
   private List<Board> boards = new ArrayList<>();
   
   @OneToOne(mappedBy="payment")
   private Cart cart;
   
}