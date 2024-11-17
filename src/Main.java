/*
 Допустим, у вас в программе есть класс Programmer. Кроме имени у нег есть поле String status; и этот статус может иметь значение «доступен» «занят» и «не доступен».  У программиста необходимо реализовать метод String doWork(String taskMsg) который в качестве результата, либо возвращает stringMsg большими буквами, либо ProgrammerBusyException, либо ProgrammerUnavailableNowException в зависимости от текущего состояния программера.
В зависимости от результата, вызывающий main выводить результат работы или сообщение «Программист занят другой задачей» или «Программист не доступен».

 Допустим, у вас в программе есть TeamLead, который тоже может быть «доступен» и «не доступен», что определяется текущим значением поля status. Еще у него есть поле List<Programmer> team, которое содержит список. Реализовать метод String doTask(String taskMsg), который пытается «поручить» задачу первому доступному программисту ( вызвав у него doWork(String taskMsg) и вернут результат, либо возвращает TeamLeadUnavailableNowException либо AllProgrammersAreBusyNowException. В зависимости от результата, вызывающий main выводить результат работы или сообщение «Нам не хватает программистов!» или «Почему TeamLead не на месте».



 */


import Excepions.ProgrammerBusyException;
import Excepions.ProgrammerUnavailableNowException;

public class Main {
    public static void main(String[] args) {
        Programmer programmer = new Programmer("Jack");
        System.out.println(programmer);
        System.out.println("меняем статус:");
        programmer.setBusy();
        System.out.println(programmer);
        System.out.println();

        try {
            System.out.println(programmer.doWork("java"));
        } catch (ProgrammerUnavailableNowException e){
            System.out.println("Программист не доступен");
        } catch (ProgrammerBusyException e){
            System.out.println("Программист занят другой задачей");
        }

    }
}