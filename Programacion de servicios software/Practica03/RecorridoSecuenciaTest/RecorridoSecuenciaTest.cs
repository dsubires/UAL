using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Collections;
using System.Collections.Generic;
using System.Collections.Specialized;
using dsp086.Practica_02;

namespace dsp086.Practica_03
{


    /// <summary>
    ///This is a test class for RecorridoUsuariosTest and is intended
    ///to contain all RecorridoUsuariosTest Unit Tests
    ///</summary>
    [TestClass()]
    public class RecorridoSecuencianUsuariosTest
    {


        private TestContext testContextInstance;
        Coleccion<UsuarioView> Usuarios;
        Coleccion<UsuarioView> VectorUsuariosAdelante;
        Coleccion<UsuarioView> VectorUsuariosAtras;
        /// <summary>
        ///Gets or sets the test context which provides
        ///information about and functionality for the current test run.
        ///</summary>
        public TestContext TestContext
        {
            get
            {
                return testContextInstance;
            }
            set
            {
                testContextInstance = value;
            }
        }

        #region Additional test attributes
        // 
        //You can use the following additional attributes as you write your tests:
        //
        //Use ClassInitialize to run code before running the first test in the class
        //[ClassInitialize()]
        //public static void MyClassInitialize(TestContext testContext)
        //{
        //}
        //
        //Use ClassCleanup to run code after all tests in a class have run
        //[ClassCleanup()]
        //public static void MyClassCleanup()
        //{
        //}
        //
        //Use TestInitialize to run code before running each test
        [TestInitialize()]
        public void MyTestInitialize()
        {
            DateTime fecha = DateTime.Now;
            Random rnd = new Random(fecha.Second);
            int[] temp = new int[10];

            Usuarios = new Coleccion<UsuarioView>(new List<UsuarioView>());
            for (int i = 0; i < 10; i++)
            {
                temp[i] = rnd.Next(0, 9);
                string snum = temp[i].ToString();
                Usuarios.Add(new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum,true));
            }


            VectorUsuariosAdelante = new Coleccion<UsuarioView>(new List<UsuarioView>());
            for (int i = 0; i < 10; i++)
            {
                string snum = temp[i].ToString();
                VectorUsuariosAdelante.Add(new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum,true));
            }

            VectorUsuariosAtras = new Coleccion<UsuarioView>(new List<UsuarioView>());
            for (int i = 0; i < 10; i++)
            {
                string snum = temp[9 - i].ToString();
                VectorUsuariosAtras.Add(new UsuarioView(9 - i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum,true));
            }



        }
        //
        //Use TestCleanup to run code after each test has run
        //[TestCleanup()]
        //public void MyTestCleanup()
        //{
        //}
        //
        #endregion


        public class ComparadorNombreAscendente : IComparer<UsuarioView>
        {

            public int Compare(object x, object y)
            {
                UsuarioView ux = x as UsuarioView;
                UsuarioView uy = y as UsuarioView;
                return Compare(ux, uy);
            }


            public int Compare(UsuarioView x, UsuarioView y)
            {
                return (x.Nombre.CompareTo(y.Nombre));
            }
        }

        public class ComparadorNombreDescendente : IComparer<UsuarioView>
        {

            public int Compare(object x, object y)
            {
                UsuarioView ux = x as UsuarioView;
                UsuarioView uy = y as UsuarioView;
                return Compare(uy, ux);
            }
            public int Compare(UsuarioView x, UsuarioView y)
            {
                return (y.Nombre.CompareTo(x.Nombre));
            }

        }


        bool RecorridoMismoSentido(IEnumerator<UsuarioView> enumExpected, IEnumerable<UsuarioView> actual)
        {
            if (enumExpected == null && actual == null) return true;
            if (enumExpected == null || actual == null) return false;

         //   IEnumerator<UsuarioView> enumExpected = expected.GetEnumerator();
         //   enumExpected.Reset();
            foreach (UsuarioView user in actual)
            {
                if (enumExpected.MoveNext())
                {
                    if (enumExpected.Current != user) return false;
                }
                else return false;
            }
            return true;
        }



        /// <summary>
        ///recorrido de atras hacia adelante
        ///</summary>
        [TestMethod()]
        public void RecorridoEnumeradorAdelanteTest()
        {
            RecorridoSecuencia<UsuarioView> target = new RecorridoSecuencia<UsuarioView>(Usuarios); // TODO: Initialize to an appropriate value
            Coleccion<UsuarioView> expected = VectorUsuariosAdelante;
            IEnumerator<UsuarioView> enuAdelante = new EnumeradorAdelante<UsuarioView>(Usuarios);
           // IEnumerable<UsuarioView> actual =  target.EnumeradorParametro(enuAdelante);
            bool igual = RecorridoMismoSentido(enuAdelante, expected);
            Assert.IsTrue(igual);
        }

        /// <summary>
        ///recorrido de adelante hacia atras 
        ///</summary>
        [TestMethod()]
        public void RecorridoEnumeradorAtrasTest()
        {
            RecorridoSecuencia<UsuarioView> target = new RecorridoSecuencia<UsuarioView>(Usuarios); // TODO: Initialize to an appropriate value
            Coleccion<UsuarioView> expected = VectorUsuariosAtras;
            IEnumerator<UsuarioView> enuAtras = new EnumeradorAtras<UsuarioView>(Usuarios);
        //    IEnumerable<UsuarioView>actual = target.EnumeradorParametro(enuAtras);
            bool igual = RecorridoMismoSentido(enuAtras,expected);
            Assert.IsTrue(igual);
        }


        /// <summary>
        ///recorrido de atras hacia adelante
        ///</summary>
        [TestMethod()]
        public void RecorridoEnumeradorAscendenteTest()
        {
            RecorridoSecuencia<UsuarioView> target = new RecorridoSecuencia<UsuarioView>(Usuarios); // TODO: Initialize to an appropriate value
            Coleccion<UsuarioView> expected = new Coleccion<UsuarioView>(Usuarios);

            ComparadorNombreAscendente compAsc = new ComparadorNombreAscendente();

            expected.Sort(compAsc);


            IEnumerator<UsuarioView> enuAdelante = new EnumeradorAscendente<UsuarioView>(Usuarios,"Nombre");
            // IEnumerable<UsuarioView> actual =  target.EnumeradorParametro(enuAdelante);
            bool igual = RecorridoMismoSentido(enuAdelante, expected);
            Assert.IsTrue(igual);
        }

        /// <summary>
        ///recorrido de adelante hacia atras 
        ///</summary>
        [TestMethod()]
        public void RecorridoEnumeradorDescendenteTest()
        {
            RecorridoSecuencia<UsuarioView> target = new RecorridoSecuencia<UsuarioView>(Usuarios); // TODO: Initialize to an appropriate value
            Coleccion<UsuarioView> expected = new Coleccion<UsuarioView>(Usuarios);

            ComparadorNombreDescendente compDesc = new ComparadorNombreDescendente();

            expected.Sort(compDesc);
            IEnumerator<UsuarioView> enuAtras = new EnumeradorDescendente<UsuarioView>(Usuarios,"Nombre");
            //    IEnumerable<UsuarioView>actual = target.EnumeradorParametro(enuAtras);
            bool igual = RecorridoMismoSentido(enuAtras, expected);
            Console.WriteLine(enuAtras);
            Console.WriteLine(expected);
            Assert.IsTrue(igual);
        }
        /// <summary>
        ///Recorrido Yield Adelante
        ///</summary>
        ///
        [TestMethod()]
        public void RecorridoYieldAdelanteTest()
        {
            RecorridoSecuencia<UsuarioView> target = new RecorridoSecuencia<UsuarioView>(Usuarios); // TODO: Initialize to an appropriate value
            Coleccion<UsuarioView> expected = VectorUsuariosAdelante;
           // IEnumerable<UsuarioView> actual = (IEnumerable<UsuarioView>)target.YieldAdelante();
            bool igual = RecorridoMismoSentido(target.YieldAdelante(), expected);
            Assert.IsTrue(igual);
        }



        /// <summary>
        ///Recorrido Yield Atras
        ///</summary>
        ///
        [TestMethod()]
        public void RecorridoYieldAtrasTest()
        {
            RecorridoSecuencia<UsuarioView> target = new RecorridoSecuencia<UsuarioView>(Usuarios); // TODO: Initialize to an appropriate value
            Coleccion<UsuarioView> expected = VectorUsuariosAtras;
           // IEnumerable<UsuarioView> actual = (IEnumerable<UsuarioView>)target.YieldAtras();
            bool igual = RecorridoMismoSentido(target.YieldAtras(),expected);
            Assert.IsTrue(igual);
        }



        /// <summary>
        ///Recorrido Yield Ascendente
        ///</summary>
        ///
        [TestMethod()]
        public void RecorridoYieldAscendenteTest()
        {
            RecorridoSecuencia<UsuarioView> target = new RecorridoSecuencia<UsuarioView>(Usuarios); // TODO: Initialize to an appropriate value

            Coleccion<UsuarioView> expected = new Coleccion<UsuarioView>(Usuarios);

            ComparadorNombreAscendente compAsc = new ComparadorNombreAscendente();

            expected.Sort(compAsc);

          //  IEnumerable<UsuarioView> actual = target.YieldAscendente("Nombre");

            bool igual = RecorridoMismoSentido(target.YieldAscendente("Nombre"),expected);
            Assert.IsTrue(igual);
        }

        /// <summary>
        ///Recorrido Yield Descendente
        ///</summary>
        ///
        [TestMethod()]
        public void RecorridoYieldDescendenteTest()
        {
            RecorridoSecuencia<UsuarioView> target = new RecorridoSecuencia<UsuarioView>(Usuarios); // TODO: Initialize to an appropriate value

            Coleccion<UsuarioView> expected = new Coleccion<UsuarioView>(Usuarios);

            ComparadorNombreDescendente compDesc = new ComparadorNombreDescendente();

            expected.Sort(compDesc);

           // IEnumerable<UsuarioView>actual = target.YieldDescendente("Nombre");

            bool igual = RecorridoMismoSentido(target.YieldDescendente("Nombre"),expected);
            Assert.IsTrue(igual);
        }

      

    }




    
}

