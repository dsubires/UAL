using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace dsp086.Practica_05
{
    class TiroAlBlancoConsolaApp
    {
        static void Main(string[] args)
        {
            string nombre, mensaje, respuesta, dificultad;
            double angulo, velocidad;
            MisilBalistico misil;
            bool dificultadSeleccionada,fin = false;
            while (!fin)
            {

                
                //obtenemos nombre jugador
                Console.Write(Strings.InputName);
                nombre = Console.ReadLine();
                Usuario usuario;

                //obtenemos dificultad
                dificultadSeleccionada = false;
                dificultad = "";
                while (!dificultadSeleccionada)
                {
                    Console.WriteLine(Strings.InputDifficult);
                    Console.WriteLine("1) "+Strings.DifficultE);
                    Console.WriteLine("2) "+Strings.DifficultN);
                    Console.WriteLine("3) "+Strings.DifficultD);
                    Console.WriteLine("");
                    try
                    {
                        int d = Convert.ToInt32(Console.ReadLine());
                        if (d == 1)
                        {
                            dificultad = "facil";
                            dificultadSeleccionada = true;
                        }
                        else if (d == 2)
                        {
                            dificultad = "normal";
                            dificultadSeleccionada = true;
                        }
                        else if (d == 3)
                        {
                            dificultad = "dificil";
                            dificultadSeleccionada = true;
                        }   
                    }
                    catch (FormatException e)
                    {
                        Console.WriteLine(Strings.ExceptionNumber);
                    }
     
                }
                //inicializamos usuario y partida
                if (nombre.Equals(""))
                    usuario = new Usuario();
                else
                    usuario = new Usuario(nombre);
                Partida partida = new Partida(new Usuario(nombre));

                Console.WriteLine(Strings.Welcome + " " + usuario.UsuarioId);
                Console.WriteLine(Strings.DistanceTarget + " " + partida.Objetivo.Distancia);

                //bucle principal partida
                //obtenemos datos de lanzamiento y lanzamos misil
                misil = null;
                while (!partida.ObjetivoAlcanzado)
                {
                    
     
                        Console.Write(Strings.InputAngle);
                        angulo = Double.Parse(Console.ReadLine());
                          Console.Write(Strings.InputSpeed);
                    velocidad = Double.Parse(Console.ReadLine());
                    if (dificultad.Equals("normal"))
                        misil = new MisilBalistico(velocidad, angulo);
                    else if (dificultad.Equals("facil"))
                        misil = new MisilBalistico(velocidad, angulo, "nuclear");
                    else if(dificultad.Equals("dificil"))
                        misil = new MisilBalistico(velocidad, angulo, "balistico");
                    
                    partida.DispararMisil(misil);
                    mensaje = partida.NumDisparos + "º " + Strings.NumShoot + " " + partida.Usuario.UsuarioId;
                    if (partida.ObjetivoAlcanzado)
                    {
                        if (dificultad.Equals("normal"))
                        {
                            Console.WriteLine(mensaje + ": "+ Strings.Missile + " 1m");
                            Console.WriteLine(Strings.TargetDestroyed + partida.NumDisparos + " INTENTOS en dificultad normal");       
                        }
                        else if (dificultad.Equals("facil")){
                            Console.WriteLine(mensaje + ": "+ Strings.Missile + " 3m");
                            Console.WriteLine(Strings.TargetDestroyed + partida.NumDisparos + " INTENTOS en dificultad fácil");
                        }
                        else if (dificultad.Equals("dificil"))
                        {
                            Console.WriteLine(mensaje + ": "+ Strings.Missile + " 0.5m");
                            Console.WriteLine(Strings.TargetDestroyed + partida.NumDisparos + " INTENTOS en dificultad difícil");
                        } 
                    }
                    else
                        Console.WriteLine(mensaje + ": " +Strings.MissileDown  + partida.DistanciaRelativaImpacto + "m");
                    Console.WriteLine("");
                }

                    
                  

                Console.Write(Strings.PlayAgain);
                respuesta = Console.ReadLine();
                if(respuesta.Equals("no") || respuesta.Equals("No") || respuesta.Equals("NO"))
                    fin = true;
               

            }
        }
    }
}
