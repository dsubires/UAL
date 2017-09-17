using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.Collections.Generic;

namespace dsp086.Practica_06
{
    [TestClass]
    public class BingoUnitTest
    {
        [TestMethod]
        public void CrearBolaTest()
        {
            Bola bola = new Bola();
            Assert.IsNotNull(bola);
        }

        [TestMethod]
        public void NumeroValidoBolaTest()
        {
            Bola bola = new Bola();
            bola.Numero = 1;
            Assert.AreEqual(bola.Numero, 1);
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentOutOfRangeException))]
        public void NumeroValidoBolaExceptionTest()
        {
            Bola bola = new Bola();
            bola.Numero = 0;
        }

        [TestMethod]
        public void CrearBomboTest()
        {
            Bombo bombo = new Bombo();
            Assert.IsNotNull(bombo);
        }

        [TestMethod]
        public void NumeroBolasBomboCreadoEsCeroTest()
        {
            Bombo bombo = new Bombo();
            Assert.AreEqual(bombo.NumeroBolas, 0);
        }

        [TestMethod]
        public void MeterBolaBomboCreadoEsUnoTest()
        {
            Bombo bombo = new Bombo();
            Bola bola = new Bola();
            bola.Numero = 1;
            bombo.MeterBola(bola);
            Assert.AreEqual(bombo.NumeroBolas, 1);
        }

        [TestMethod]
        public void MeterBolaBomboCreadoEstaDentroTest()
        {
            Bombo bombo = new Bombo();
            Bola bola = new Bola();
            bola.Numero = 1;
            bombo.MeterBola(bola);
            bool estaBola = bombo.EstaBola(bola);
            Assert.IsTrue(estaBola);
        }

        [TestMethod]
        public void MeterMismaBolaBomboCreadoEstaDentroTest()
        {
            Bombo bombo = new Bombo();
            Bola bola = new Bola();
            bola.Numero = 1;
            bombo.MeterBola(bola);
            Bola mismaBola = new Bola();
            mismaBola.Numero = 1;
            bool estaBola = bombo.EstaBola(mismaBola);
            Assert.IsTrue(estaBola);
        }

        [TestMethod]
        public void DistintaBolaMismoNumeroTest()
        {
            Bola bola = new Bola();
            bola.Numero = 1;
            Bola otraBola = new Bola();
            otraBola.Numero = 1;
            Assert.AreEqual(bola, otraBola);
        }

        [TestMethod]
        public void MeterBolaBomboCreadoCambiarlaNoEstaDentroTest()
        {
            Bombo bombo = new Bombo();
            Bola bola = new Bola();
            bola.Numero = 1;
            bombo.MeterBola(bola);
            bola.Numero = 2;
            bool estaBola = bombo.EstaBola(bola);
            Assert.IsFalse(estaBola);
        }

        [TestMethod]
        public void MeterYSacarBolaBomboCreadoNoEstaDentroTest()
        {
            Bombo bombo = new Bombo();
            Bola bola = new Bola();
            bola.Numero = 1;
            bombo.MeterBola(bola);
            bombo.SacarBola(bola);
            bool estaBola = bombo.EstaBola(bola);
            Assert.IsFalse(estaBola);
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentOutOfRangeException))]
        public void SacarBolaNoEstaBomboCreadoExceptionTest()
        {
            Bombo bombo = new Bombo();
            Bola bola = new Bola();
            bola.Numero = 1;
            bombo.SacarBola(bola);
        }

        [TestMethod]
        public void MeterTodasBolasContadorBomboCreadoTest()
        {
            Bombo bombo = new Bombo();
            for (int i = 0; i < 90; i++)
            {
                Bola bola = new Bola();
                bola.Numero = i + 1;
                bombo.MeterBola(bola);
            }
            Assert.AreEqual(bombo.NumeroBolas, 90);
        }

        [TestMethod]
        public void MeterYSacarTodasBolasContadorBomboCreadoTest()
        {
            Bombo bombo = new Bombo();
            for (int i = 0; i < 90; i++)
            {
                Bola bola = new Bola();
                bola.Numero = i + 1;
                bombo.MeterBola(bola);
            }
            for (int i = 0; i < 90; i++)
            {
                Bola bola = new Bola();
                bola.Numero = i + 1;
                bombo.SacarBola(bola);
            }
            Assert.AreEqual(bombo.NumeroBolas, 0);
        }
        [TestMethod]
        public void MeterDosVecesMismaBolaContadorBomboCreadoTest()
        {
            Bombo bombo = new Bombo();
            Bola bola = new Bola();
            bola.Numero = 1;
            bombo.MeterBola(bola);
            bombo.MeterBola(bola);
            Assert.AreEqual(bombo.NumeroBolas, 1);
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentOutOfRangeException))]
        public void SacarDosVecesMismaBolaContadorBomboCreadoExcepcionTest()
        {
            Bombo bombo = new Bombo();
            Bola bola = new Bola();
            bola.Numero = 1;
            bombo.MeterBola(bola);
            bombo.SacarBola(bola);
            bombo.SacarBola(bola);
        }

        [TestMethod]
        public void GenerarNumeroAleatoriaEntre1y90Test()
        {
            Random ramdom = new Random(DateTime.Now.Millisecond);
            int numeroAleatorio = ramdom.Next(1, 91);
            Assert.IsTrue((numeroAleatorio >= 1 && numeroAleatorio <= 90));
        }


        [TestMethod]
        public void SacarBolaAleatoriaDeBomboLlenoTest()
        {
            Random ramdom = new Random(DateTime.Now.Millisecond);
            int numeroAleatorio = ramdom.Next(1, 91);
            Bola bolaAleatoria = new Bola();
            bolaAleatoria.Numero = numeroAleatorio;

            Bombo bombo = new Bombo();
            for (int i = 0; i < 90; i++)
            {
                Bola bola = new Bola();
                bola.Numero = i + 1;
                bombo.MeterBola(bola);
            }

            bombo.SacarBola(bolaAleatoria);
            Assert.IsFalse(bombo.EstaBola(bolaAleatoria));
        }

        [TestMethod]
        public void SacarBolaAleatoriaDeBomboAleatorioTest()
        {
            Bombo bombo = new Bombo();
            Random ramdom = new Random(DateTime.Now.Millisecond);
            int totalAleatorio = ramdom.Next(1, 91);
            for (int i = 0; i < totalAleatorio; i++)
            {
                Bola bola = new Bola();
                int numeroAleatorio = ramdom.Next(1, 91);
                bola.Numero = numeroAleatorio;
                bombo.MeterBola(bola);
            }

            int numeroAleatorioSacar = ramdom.Next(1, 91);
            Bola bolaAleatoria = bombo.ElegirBola();

            bombo.SacarBola(bolaAleatoria);
            Assert.IsFalse(bombo.EstaBola(bolaAleatoria));
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentOutOfRangeException))]
        public void SacarBolaAleatoriaDeBomboVacioTest()
        {
            Bombo bombo = new Bombo();
            Random ramdom = new Random(DateTime.Now.Millisecond);
            int totalAleatorio = ramdom.Next(1, 91);
            for (int i = 0; i < totalAleatorio; i++)
            {
                Bola bola = new Bola();
                int numeroAleatorio = ramdom.Next(1, 91);
                bola.Numero = numeroAleatorio;
                bombo.MeterBola(bola);
                bombo.SacarBola(bola);
            }

            int numeroAleatorioSacar = ramdom.Next(1, 91);
            Bola bolaAleatoria = bombo.ElegirBola();

            bombo.SacarBola(bolaAleatoria);
        }

        [TestMethod]
        public void CrearCartonTest()
        {
            Carton carton = new Carton();
            Assert.IsNotNull(carton);
        }

        [TestMethod]
        public void CrearCartonTiene15NumerosTest()
        {
            Carton carton = new Carton();
            Assert.AreEqual(carton.NumeroBolasSinTachar, 15);
        }

        [TestMethod]
        public void SacarTodasLasBolasDeBomboYTacharCartonTest()
        {
            Bombo bombo = new Bombo();
            for (int i = 0; i < 90; i++)
            {
                Bola bola = new Bola();
                bola.Numero = i + 1;
                bombo.MeterBola(bola);
            }
            Carton carton = new Carton();
            for (int i = 0; i < 90; i++)
            {
                Bola bola = new Bola();
                bola.Numero = i + 1;
                bombo.SacarBola(bola);
                carton.TacharBola(bola);
            }
            Assert.AreEqual(carton.NumeroBolasSinTachar, 0);
        }

        [TestMethod]
        public void SacarTodasLasBolasDeBomboYTacharCarton2Test()
        {
            Bombo bombo = new Bombo();
            for (int i = 0; i < 90; i++)
            {
                Bola bola = new Bola();
                bola.Numero = i + 1;
                bombo.MeterBola(bola);
            }
            Carton2 carton = new Carton2();
            for (int i = 0; i < 90; i++)
            {
                Bola bola = new Bola();
                bola.Numero = i + 1;
                bombo.SacarBola(bola);
            }
            Assert.AreEqual(carton.NumeroBolasSinTachar(bombo), 0);
        }

        [TestMethod]
        public void DinamicaJuego()
        {

            Bombo bombo = new Bombo();
            bombo.Rellenar();
            List<Carton> cartones = new List<Carton>();
            List<Carton> cartonesGanadores = new List<Carton>();
            for (int i = 0; i < 1000; i++)
            {
                cartones.Add(new Carton());
            }
            bool finJuego = false;
            while (!finJuego)
            {
                var bola = bombo.ElegirBola();
                bombo.SacarBola(bola);
                foreach (var carton in cartones)
                {
                    carton.TacharBola(bola);
                    if (carton.NumeroBolasSinTachar == 0) cartonesGanadores.Add(carton);
                    finJuego = (carton.NumeroBolasSinTachar == 0);
                }
            }
        }

        [TestMethod]
        public void DinamicaJuego2()
        {

            Bombo bombo = new Bombo();
            bombo.Rellenar();
            List<Carton2> cartones2 = new List<Carton2>();
            List<Carton2> cartones2Ganadores = new List<Carton2>();
            for (int i = 0; i < 1000; i++)
            {
                cartones2.Add(new Carton2());
            }
            bool finJuego = false;
            while (!finJuego)
            {
                var bola = bombo.ElegirBola();
                bombo.SacarBola(bola);
                foreach (var carton2 in cartones2)
                {
                    if (carton2.NumeroBolasSinTachar(bombo) == 0) cartones2Ganadores.Add(carton2);
                    finJuego = (carton2.NumeroBolasSinTachar(bombo) == 0);
                }
            }
        }

        [TestMethod]
        public void SacarTodasLasBolasDeBomboYTacharCartonListaTest()
        {
            Bombo bombo = new Bombo();
            for (int i = 0; i < 90; i++)
            {
                Bola bola = new Bola();
                bola.Numero = i + 1;
                bombo.MeterBola(bola);
            }
            CartonLista carton = new CartonLista();
            for (int i = 0; i < 90; i++)
            {
                Bola bola = new Bola();
                bola.Numero = i + 1;
                bombo.SacarBola(bola);
            }
            Assert.AreEqual(carton.NumeroBolasSinTachar(bombo), 0);
        }

        [TestMethod]
        public void SacarTodasLasBolasDeBomboYComprobarPremioLineaTest()
        {
            Bombo bombo = new Bombo();
            for (int i = 0; i < 90; i++)
            {
                Bola bola = new Bola();
                bola.Numero = i + 1;
                bombo.MeterBola(bola);
            }
            CartonLista carton = new CartonLista();
            for (int i = 0; i < 90; i++)
            {
                Bola bola = new Bola();
                bola.Numero = i + 1;
                bombo.SacarBola(bola);
            }

            Assert.IsTrue(carton.CompruebaLinea(bombo));
        }


        [TestMethod]
        public void DinamicaJuegoConPremioLineaYBingo()
        {

            Bombo bombo = new Bombo();
            bombo.Rellenar();
            List<CartonLista> cartones = new List<CartonLista>();
            List<CartonLista> cartonesGanadoresLinea = new List<CartonLista>();
            List<CartonLista> cartonesGanadoresBingo = new List<CartonLista>();
            for (int i = 0; i < 1000; i++)
            {
                cartones.Add(new CartonLista());
            }
            bool finJuego = false;
            bool hanCantadoLinea = false;
            while (!finJuego)
            {
                var bola = bombo.ElegirBola();
                bombo.SacarBola(bola);
                if (cartonesGanadoresLinea.Count != 0)
                    hanCantadoLinea = true;
                foreach (var carton in cartones)
                {
                    if (carton.NumeroBolasSinTachar(bombo) == 0) cartonesGanadoresBingo.Add(carton);
                    if (!hanCantadoLinea)
                        if (carton.CompruebaLinea(bombo)) cartonesGanadoresLinea.Add(carton);
                    finJuego = (carton.NumeroBolasSinTachar(bombo) == 0);
                }
            }

            Assert.IsTrue(cartonesGanadoresBingo.Count > 0);
            Assert.IsTrue(cartonesGanadoresLinea.Count > 0);


        }
        [TestMethod]
        public void SacarTodasLasBolasDeBomboYTacharCartonLineaBoolTest()
        {
            Bombo bombo = new Bombo();
            for (int i = 0; i < 90; i++)
            {
                Bola bola = new Bola();
                bola.Numero = i + 1;
                bombo.MeterBola(bola);
            }
            CartonLineaBool carton = new CartonLineaBool();
            for (int i = 0; i < 90; i++)
            {
                Bola bola = new Bola();
                bola.Numero = i + 1;
                bombo.SacarBola(bola);
                carton.TacharBola(bola);
            }
            Assert.AreEqual(carton.NumeroBolasSinTachar(), 0);
        }

        [TestMethod]
        public void SacarTodasLasBolasDeBomboYComprobarPremioLineaBoolTest()
        {
            Bombo bombo = new Bombo();
            for (int i = 0; i < 90; i++)
            {
                Bola bola = new Bola();
                bola.Numero = i + 1;
                bombo.MeterBola(bola);
            }
            CartonLineaBool carton = new CartonLineaBool();
            for (int i = 0; i < 90; i++)
            {
                Bola bola = new Bola();
                bola.Numero = i + 1;
                bombo.SacarBola(bola);
                carton.TacharBola(bola);
            }

            Assert.IsTrue(carton.CompruebaLinea());
        }


        [TestMethod]
        public void DinamicaJuegoConPremioLineaYBingoLineaBoolTest()
        {

            Bombo bombo = new Bombo();
            bombo.Rellenar();
            List<CartonLineaBool> cartones = new List<CartonLineaBool>();
            List<CartonLineaBool> cartonesGanadoresLinea = new List<CartonLineaBool>();
            List<CartonLineaBool> cartonesGanadoresBingo = new List<CartonLineaBool>();
            for (int i = 0; i < 1000; i++)
            {
                cartones.Add(new CartonLineaBool());
            }
            bool finJuego = false;
            bool hanCantadoLinea = false;
            while (!finJuego)
            {
                var bola = bombo.ElegirBola();
                bombo.SacarBola(bola);
                if (cartonesGanadoresLinea.Count != 0)
                    hanCantadoLinea = true;
                foreach (var carton in cartones)
                {
                    carton.TacharBola(bola);
                    if (carton.NumeroBolasSinTachar() == 0) cartonesGanadoresBingo.Add(carton);
                    if (!hanCantadoLinea)
                        if (carton.CompruebaLinea()) cartonesGanadoresLinea.Add(carton);
                    finJuego = (carton.NumeroBolasSinTachar() == 0);
                }
            }

            Assert.IsTrue(cartonesGanadoresBingo.Count > 0);
            Assert.IsTrue(cartonesGanadoresLinea.Count > 0);


        }

    }
}
