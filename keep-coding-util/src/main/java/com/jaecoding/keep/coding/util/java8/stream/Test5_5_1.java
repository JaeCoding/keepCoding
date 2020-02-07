package com.jaecoding.keep.coding.util.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class Test5_5_1 {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        /*
        找出2011年发生的所有交易，并 按交易额排序 （从低到高）
         */
        List<Transaction> transactionslist =
                transactions.stream()
                        .filter(transaction -> transaction.getYear() == 2011)
                        .sorted(comparing(Transaction::getValue))
                        .collect(toList());

        /*
        交易员都在哪些不同的城市工作过？
         */
        List<String> city =
                transactions.stream()
                        .map(transaction -> transaction.getTrader().getCity())
                        .distinct()
                        .collect(toList());

        /*
        查找所有来自于剑桥的交易员，并按姓名排序
         */
        List<Trader> orderTraders =
                transactions.stream()
                        .map(Transaction::getTrader)
                        .filter(trader -> "Cambridge".equals(trader.getCity()))
                        .sorted(comparing(Trader::getName))
                        .collect(toList());

        /*
        返回所有交易员的姓名字符串，按字母顺序排序
         */
        List<String> names =
                transactions.stream()
                        .map(transaction -> transaction.getTrader().getName())
                        .distinct()
                        .sorted()
                        .collect(toList());

        /*
         有没有交易员是在米兰工作的
         */
        Boolean isMi =
                transactions.stream()
                        .anyMatch(transaction -> "Milan".equals(transaction.getTrader().getCity()));

        /*
        打印生活在剑桥的交易员的所有交易额
         */
        transactions.stream()
                .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        /*
        所有交易中，最高的交易额是多少
         */
        int maxMoney =
                transactions.stream()
                        .map(Transaction::getValue)
                        .reduce(Integer.MIN_VALUE, Math::max);
        Optional<Integer> optionalInteger =
                transactions.stream()
                        .map(Transaction::getValue)
                        .reduce(Math::max);

        /*
        找到交易额最小的交易 注意是交易
        记录错题
         */
        Optional<Transaction> optional =
                transactions.stream()
                        .reduce((a, b) -> a.getValue() < b.getValue() ? a : b);

        Optional<Transaction> optional2 =
                transactions.stream()
                        .min(comparing(Transaction::getValue));

    }
}
