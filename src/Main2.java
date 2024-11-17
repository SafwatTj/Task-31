/*
 Допустим, у вас в программе есть класс Programmer. Кроме имени у нег есть поле String status; и этот статус может иметь значение «доступен» «занят» и «не доступен».  У программиста необходимо реализовать метод String doWork(String taskMsg) который в качестве результата, либо возвращает stringMsg большими буквами, либо ProgrammerBusyException, либо ProgrammerUnavailableNowException в зависимости от текущего состояния программера.
В зависимости от результата, вызывающий main выводить результат работы или сообщение «Программист занят другой задачей» или «Программист не доступен».

 Допустим, у вас в программе есть TeamLead, который тоже может быть «доступен» и «не доступен», что определяется текущим значением поля status. Еще у него есть поле List<Programmer> team, которое содержит список. Реализовать метод String doTask(String taskMsg), который пытается «поручить» задачу первому доступному программисту ( вызвав у него doWork(String taskMsg) и вернут результат, либо возвращает TeamLeadUnavailableNowException либо AllProgrammersAreBusyNowException. В зависимости от результата, вызывающий main выводить результат работы или сообщение «Нам не хватает программистов!» или «Почему TeamLead не на месте».



 */


import Excepions.AllProgrammersAreBusyNowException;
import Excepions.ProgrammerBusyException;
import Excepions.ProgrammerUnavailableNowException;
import Excepions.TeamLeadUnavailableNowException;

import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        Programmer jack = new Programmer("Jack");
        Programmer john = new Programmer("John");

        TeamLead teamLead = new TeamLead("Lena", TeamLeadStatus.AVAILABLE, List.of(jack, john));
        System.out.println(teamLead);

        teamLead.setStatus(TeamLeadStatus.AVAILABLE);
        jack.setBusy();
        john.setAvailable();
        try {
            System.out.println(teamLead.doTask("java exceptions are easy"));
        } catch (AllProgrammersAreBusyNowException e){
            System.out.println("Нам не хватает программистов!");
        } catch (TeamLeadUnavailableNowException e){
            System.out.println("Почему TeamLead не на месте!");
        }
    }
}