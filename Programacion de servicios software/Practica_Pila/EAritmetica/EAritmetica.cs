using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace dsp086.Practica_04
{
    public class EAritmetica
    {


        public double EvaluaPostfija(String ExpPostfija)
        {
            double op1, op2, result;
            Pila<double> pila = new Pila<double>();
            ExpPostfija = ExpPostfija.Replace(".", ",");
            String[] elements = ExpPostfija.Split(' ');

//            for (int i = 0; i < ExpPostfija.Length; i++)
            foreach(String current in elements)
            {
                if (!EsOperador(current))
                   pila.Meter(Double.Parse(current));
                else
                {
                    op2 = pila.Sacar();
                    op1 = pila.Sacar();
                    result = Evalua(op1, op2, current);
                    pila.Meter(result);
                }
            }

                return pila.Sacar();
        }

        private double Evalua(double op1, double op2, String op)
        {
            double result = 0;

            switch (op)
            {
                case "^":
                    result = Math.Pow(op1, op2);
                    break;
                case "*":
                    result = op1 * op2;
                    break;
                case "/":
                    result = op1 / op2;
                    break;
                case "+":
                    result = op1 + op2;
                    break;
                case "-":
                    result = op1 - op2;
                    break;
            }

            return result;
        }

        public String InfijaToPostfija(String infija)
        {
            String postfija = "";
            String[] elements;
            Pila<Char> pila = new Pila<Char>();
            Char aux, current;
            Boolean salir;

            elements = infija.Split(' ');
            foreach(string element in elements)
            {
//                current = Char.Parse(element);
//                if (Char.IsDigit(current))
                if(!EsOperador(element) && !element.Equals(")"))
                {   // es digito
                    postfija += element + " ";
                }
                else
                {
                    if (EsOperador(element))
                    {   //es operador
                        salir = false;
                        while (!salir)
                        {
                            if (pila.EsVacia || (PrioridadInfija(Char.Parse(element)) > PrioridadPila(pila.VerUltimo())))
                            {
                                pila.Meter(Char.Parse(element));
                                salir = true;
                            }
                            else
                            {
                                // prioridad elemento pila <= current
                                aux = pila.Sacar();
                                postfija += aux + " ";
                                //pila.Meter(current); ¿?
                            }
                        }
                    }
                    else if (element.Equals(")"))
                    {
                        salir = false;
                        while (!salir)
                        {
                            aux = pila.Sacar();
                            if (aux.Equals('('))
                                salir = true;
                            else
                                postfija += aux + " ";
                        }
                    }
                }
            }
            while (!pila.EsVacia)
                postfija += pila.Sacar() + " ";


            return postfija.Substring(0, (postfija.Length-1)); //eliminamos el espacio del final
        }

        private Boolean EsOperador(String c)
        {
            if (c.Equals("^") || c.Equals("*") || c.Equals("/") || c.Equals("+") || c.Equals("-") || c.Equals("("))
                return true;
            return false;
        }

        private int PrioridadInfija(Char c)
        {
            int prioridad = -1;
            switch (c)
            {
                case '^':
                    prioridad = 4;
                    break;
                case '*':
                    prioridad = 2;
                    break;
                case '/':
                    prioridad = 2;
                    break;
                case '+':
                    prioridad = 1;
                    break;
                case '-':
                    prioridad = 1;
                    break;
                case '(':
                    prioridad = 5;
                    break;

            }
            return prioridad;
        }

        private int PrioridadPila(Char c)
        {
            int prioridad = -1;
            switch (c)
            {
                case '^':
                    prioridad = 3;
                    break;
                case '*':
                    prioridad = 2;
                    break;
                case '/':
                    prioridad = 2;
                    break;
                case '+':
                    prioridad = 1;
                    break;
                case '-':
                    prioridad = 1;
                    break;
                case '(':
                    prioridad = 0;
                    break;
            }
            return prioridad;
        }

    }
}
