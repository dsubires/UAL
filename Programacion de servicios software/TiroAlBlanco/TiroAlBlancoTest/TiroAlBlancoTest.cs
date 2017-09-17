using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using dsp086.Practica_05.Fakes;

namespace dsp086.Practica_05
{
    [TestClass]
    public class TiroAlBlancoTest
    {
        [TestMethod]
        public void CrearMisil()
        {
            IMisil misil = TiroAlBlancoFactory.CrearMisil(0,0);
            Assert.AreNotEqual(misil, null);
        }

        [TestMethod]
        public void ComprobarParametrosDisparosMisilNulos()
        {
            IMisil misil = TiroAlBlancoFactory.CrearMisil(0, 0);
            Assert.AreEqual(misil.VelocidadInicial, 0);
            Assert.AreEqual(misil.AnguloSalida, 0);
        }

        [TestMethod]
        public void ComprobarParametrosDispaoMisilNoNulos()
        {
            IMisil misil = TiroAlBlancoFactory.CrearMisil(1, 2);
            Assert.AreEqual(misil.VelocidadInicial, 1);
            Assert.AreEqual(misil.AnguloSalida, 2);
        }



        [TestMethod]
        public void CrearObjetivo()
        {
            IObjetivo blanco = TiroAlBlancoFactory.CrearObjetivoFijo(0);
            Assert.AreNotEqual(blanco, null);
        }

        [TestMethod]
        public void ComprobarDistanciaObjetivoNula()
        {
            IObjetivo blanco = TiroAlBlancoFactory.CrearObjetivoFijo(0);
            Assert.AreEqual(blanco.Distancia, 0);
        }

        [TestMethod]
        public void ComprobarDistanciaObjetivoNoNula()
        {
            IObjetivo blanco = TiroAlBlancoFactory.CrearObjetivoFijo(2);
            Assert.AreEqual(blanco.Distancia, 2);
        }

        [TestMethod]
        public void ComprobarAlcanceDisparoNulo()
        {
            IMisil misil = TiroAlBlancoFactory.CrearMisil(0, 0);
            Assert.AreEqual(misil.Alcance, 0);
        }

        [TestMethod]
        public void ComprobarAlcanceDisparoYBlancoNulo()
        {
            IObjetivo blanco = TiroAlBlancoFactory.CrearObjetivoFijo(0);
            IMisil misil = TiroAlBlancoFactory.CrearMisil(0, 0);
            Assert.AreEqual(misil.Alcance, blanco.Distancia);
        }

        [TestMethod]
        public void ComprobarAlcanceDisparoNuloSinHacerBlanco()
        {
            IObjetivo blanco = TiroAlBlancoFactory.CrearObjetivoFijo(100);
            IMisil misil = TiroAlBlancoFactory.CrearMisil(0, 0);
            Assert.AreNotEqual(misil.Alcance, blanco.Distancia);
        }

        [TestMethod]
        [ExpectedException(typeof(ObjetivoDistanciaException))]
        public void ComprobarDistanciaAlBlancoFueraLimite()
        {
            IObjetivo blanco = TiroAlBlancoFactory.CrearObjetivoFijo(100000);
            IMisil misil = TiroAlBlancoFactory.CrearMisil(10, 10);
            Assert.AreNotEqual(misil.Alcance, blanco.Distancia, 1.0);
        }

        [TestMethod]
        [ExpectedException(typeof(VelocidadMisilException))]
        public void ComprobarVelocidadMisilFueraLimite()
        {
            IObjetivo blanco = TiroAlBlancoFactory.CrearObjetivoFijo(100);
            IMisil misil = TiroAlBlancoFactory.CrearMisil(300010, 10);
            Assert.AreNotEqual(misil.Alcance, blanco.Distancia, 1.0);
        }

        [TestMethod]
        [ExpectedException(typeof(AnguloMisilException))]
        public void ComprobarAnguloMisilMenorCeroFueraLimite()
        {
            IObjetivo blanco = TiroAlBlancoFactory.CrearObjetivoFijo(100);
            IMisil misil = TiroAlBlancoFactory.CrearMisil(3010, -1);
            Assert.AreNotEqual(misil.Alcance, blanco.Distancia, 1.0);
        }


        [TestMethod]
        [ExpectedException(typeof(AnguloMisilException))]
        public void ComprobarAnguloMisilMayorNoventaFueraLimite()
        {
            IObjetivo blanco = TiroAlBlancoFactory.CrearObjetivoFijo(100);
            IMisil misil = TiroAlBlancoFactory.CrearMisil(3010, 91);
            Assert.AreNotEqual(misil.Alcance, blanco.Distancia, 1.0);
        }

        [TestMethod]
        public void ComprobarDisparoCorrecto()
        {
            IObjetivo blanco = TiroAlBlancoFactory.CrearObjetivoFijo(963.5);
            IMisil misil = TiroAlBlancoFactory.CrearMisil(350, 45);
            Assert.AreEqual(misil.Alcance, blanco.Distancia, 1.0);

        }

        [TestMethod]
        public void ComprobarJugadorPorDefecto()
        {
            IUsuario jugador = TiroAlBlancoFactory.CrearUsuario();
            Assert.AreEqual(jugador.UsuarioId, "Humano");
        }

        [TestMethod]
        public void ComprobarJugadorNombreExplicito()
        {
            IUsuario jugador = TiroAlBlancoFactory.CrearUsuario("Jose");
            Assert.AreEqual(jugador.UsuarioId, "Jose");
        }

        [TestMethod]
        public void ComprobarUsuarioPartida()
        {
            IPartida partida = TiroAlBlancoFactory.CrearPartida();
            Assert.AreEqual(partida.Usuario.UsuarioId, "Humano");
        }

        [TestMethod]
        public void ComprobarNumDisparosPartida()
        {
            IPartida partida = TiroAlBlancoFactory.CrearPartida();
            Assert.AreEqual(partida.NumDisparos, 0);
        }

        [TestMethod]
        public void ComprobarDistanciaBlancoPartida()
        {
            IPartida partida = TiroAlBlancoFactory.CrearPartida();
            Assert.IsTrue(partida.DistanciaRelativaImpacto > 0);
        }

        [TestMethod]
        public void ComprobarNuevoDisparoMisilPartida()
        {
            Partida partida = (Partida) TiroAlBlancoFactory.CrearPartida();
            IMisil misil = TiroAlBlancoFactory.CrearMisil(10, 10);
            partida.DispararMisil(misil);
            Assert.IsTrue(partida.NumDisparos == 1);
        }
      
        [TestMethod]
        public void ComprobarNuevoDisparoCertero()
        {
            IMisil misil = TiroAlBlancoFactory.CrearMisil(1459.6, 45);
            double distanciaAlBlanco = 16756.5;
            var stubPartida = new StubIPartida
            {
                UsuarioGet = () => TiroAlBlancoFactory.CrearUsuario("Jose"),
                ObjetivoGet = () => TiroAlBlancoFactory.CrearObjetivoFijo(distanciaAlBlanco),
                DispararMisilIMisil = (mm) => { mm = misil; },
                NumDisparosGet = () => 1,
                DistanciaRelativaImpactoGet = () => misil.Alcance - distanciaAlBlanco,
                ObjetivoAlcanzadoGet = () => Math.Abs(misil.Alcance - distanciaAlBlanco) < 1.0
            };

            IPartida partida = (IPartida)stubPartida;

            Assert.IsTrue(partida.ObjetivoAlcanzado);
        }

    }
}
