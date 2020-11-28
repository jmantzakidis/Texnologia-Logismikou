package com.example.loginproject;

import java.util.ArrayList;
import java.util.List;

public class TrueTable {
    List<List> trueTable;

    TrueTable(List employeeList, List hoursPerWeek)
    {
        this.trueTable=new ArrayList();
        this.trueTable.add(employeeList);
        this.trueTable.add(hoursPerWeek);
    }
    public void setWorkHours(int i)
    {
        int tmp =(int) trueTable.get(1).get(i);
        tmp+=8;
        this.trueTable.get(1).set(i, tmp);
    }

    public void setShift(int i)
    {
        this.trueTable.get(2).add(i);
    }

    public int getShift(int i)
    {
        return (int) this.trueTable.get(2).get(i);
    }

    public int getWorkHours(int i)
    {
        return (int)this.trueTable.get(1).get(i);
    }

    public int getEmployeeWithLessHours(int thesi1)
    {
        int min=thesi1;
        int thesi=min;
        for(int i=0;i<trueTable.get(1).size();i++)
        {
            int firstNum=(int)this.trueTable.get(1).get(i);
            int minNum=(int)this.trueTable.get(1).get(min);

            if(firstNum<minNum)
                thesi=i;

        }
        return thesi;
    }
    public List getList(int i)
    {
        return this.trueTable.get(i);
    }
}
