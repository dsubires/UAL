using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace dsp086.Practica_04
{
    [TestClass]
    public class PilaUnitTest
    {
        [TestMethod]
        public void NuevaPilaEsNoNula()
        {
            Pila<int> pila = new Pila<int>();
            Assert.IsNotNull(pila);
        }

        [TestMethod]
        public void NuevaPilaEsVacia()
        {
            Pila<int> pila = new Pila<int>();
            bool esVacia = pila.EsVacia;
            Assert.IsTrue(esVacia);
        }
        [TestMethod]
        public void MeterElementoNuevaPilaEsNoVacia()
        {
            Pila<int> pila = new Pila<int>();
            int elemento = 5;
            pila.Meter(elemento);
            bool esVacia = pila.EsVacia;
            Assert.IsFalse(esVacia);
        }

        [TestMethod]
        public void ComprobarUltimoElementoPila()
        {
            Pila<int> pila = new Pila<int>();
            int elemento1,elemento2,elemento3;
            elemento1 = 1;
            elemento2 = 2;
            elemento3 = 5;
            pila.Meter(elemento1);
            pila.Meter(elemento2);
            pila.Meter(elemento3);
            Assert.ReferenceEquals(elemento3, pila.VerUltimo());
        }

        [TestMethod]
        public void ComprobarPeekAndPop()
        {
            Pila<int> pila = new Pila<int>();
            int elemento1, elemento2, elemento3;
            elemento1 = 1;
            elemento2 = 2;
            elemento3 = 5;
            pila.Meter(elemento1);
            pila.Meter(elemento2);
            pila.Meter(elemento3);
            Assert.ReferenceEquals(elemento3, pila.VerUltimo());
            pila.Sacar();
            Assert.IsTrue(pila.Tamaño() == 2);
        }

        [TestMethod]
        public void VaciarPila()
        {
            Pila<int> pila = new Pila<int>();
            int elemento1, elemento2, elemento3;
            elemento1 = 1;
            elemento2 = 2;
            elemento3 = 5;
            pila.Meter(elemento1);
            pila.Meter(elemento2);
            pila.Meter(elemento3);
            pila.Vaciar();
            Assert.IsTrue(pila.EsVacia);
        }

        [TestMethod]
        [ExpectedException(typeof(Exception))]
        public void SacarElementoPilaVaciaException()
        {
            Pila<int> pila = new Pila<int>();
            pila.Sacar();
        }

        [TestMethod]
        [ExpectedException(typeof(Exception))]
        public void VerElementoPilaVaciaException()
        {
            Pila<int> pila = new Pila<int>();
            pila.VerUltimo();
        }
    }
}
