
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Collections;
using dsp086.Practica_02;

namespace dsp086.Practica_02
{


    /// <summary>
    ///This is a test class for UsuarioTest and is intended
    ///to contain all UsuarioTest Unit Tests
    ///</summary>
    [TestClass()]
    public class UsuarioIgualdadTest
    {


        private TestContext testContextInstance;

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

        #region Test de objetos iguales


        ///</summary>
        [TestMethod()]
        //sobre-escritura del metodo Equals. Objetos iguales.
        public void OverrideEquals_SameObjects_AreEqual()
        {
            //¿por qué este test lo pasa siempre?
            int i = 1;
            string snum = i.ToString();
            IUsuarioView userA = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);
            IUsuarioView userB = userA;

            bool expected = true;
            bool actual = userA.Equals(userB);
            Assert.AreEqual(expected, actual);

        }

        ///</summary>
        [TestMethod()]
        //metodo Equals statico de object. Objetos iguales.
        public void StaticEquals_SameObjects_AreEqual()
        {
            //¿por qué este test lo pasa siempre?
            int i = 1;
            string snum = i.ToString();
            UsuarioView userA = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            UsuarioView userB = userA;

            bool expected = true;
            bool actual = Equals(userA, userB);
            Assert.AreEqual(expected, actual);

        }
        ///</summary>
        [TestMethod()]
        //sobre-escritura del operador == . Valores iguales (en objetos distintos) 
        public void OperatorEqual_SameObjects_AreEqual()
        {
            int i = 1;
            string snum = i.ToString();
            UsuarioView userA = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            UsuarioView userB = userA;

            bool expected = true;
            bool actual = userA == userB;
            Assert.AreEqual(expected, actual);

        }

        [TestMethod()]
        //sobre-escritura del operador != . Valores iguales (en objetos distintos) 
        public void OperatorDistint_SameObjects_AreNotEqual()
        {
            int i = 1;
            string snum = i.ToString();
            UsuarioView userA = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            UsuarioView userB = userA;

            bool expected = true;
            bool actual = userA != userB;
            Assert.AreNotEqual(expected, actual);

        }
        #endregion


        #region Test de valores iguales


        ///</summary>
        [TestMethod()]
        //sobre-escritura del metodo Equals. Valores iguales (en objetos distintos) 
        public void OverrideEquals_DifferentObjectsWithSameId_AreEqual()
        {
            int i = 1;
            string snum = i.ToString();
            UsuarioView userA = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            i = 1;
            snum = (i + 1).ToString();
            UsuarioView userB = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            bool expected = true;
            bool actual = userA.Equals(userB);
            Assert.AreEqual(expected, actual);

        }

        ///</summary>
        [TestMethod()]
        //metodo Equals statico de object. Valores iguales (en objetos distintos) 
        public void StaticEquals_DifferentObjectsWithSameId_AreEqual()
        {
            int i = 1;
            string snum = i.ToString();
            UsuarioView userA = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            i = 1;
            snum = (i + 1).ToString();
            UsuarioView userB = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            bool expected = true;
            bool actual = object.Equals(userA, userB);
            Assert.AreEqual(expected, actual);

        }
        ///</summary>
        [TestMethod()]
        //sobre-escritura del operador == . Valores iguales (en objetos distintos) 
        public void OperatorEqual_DifferentObjectsWithSameId_AreEqual()
        {
            int i = 1;
            string snum = i.ToString();
            UsuarioView userA = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            i = 1;
            snum = (i + 1).ToString();
            UsuarioView userB = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            bool expected = true;
            bool actual = userA == userB;
            Assert.AreEqual(expected, actual);

        }

        [TestMethod()]
        //sobre-escritura del operador != . Valores iguales (en objetos distintos) 
        public void OperatorDistint_DifferentObjectsWithSameId_AreNotEqual()
        {
            int i = 1;
            string snum = i.ToString();
            UsuarioView userA = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            i = 1;
            snum = (i + 1).ToString();
            UsuarioView userB = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            bool expected = true;
            bool actual = userA != userB;
            Assert.AreNotEqual(expected, actual);

        }
        #endregion


        #region Test de valores distintos por la izquierda


        ///</summary>
        [TestMethod()]
        //sobre-escritura del metodo Equals. Valores distintos (en objetos distintos) 
        public void OverrideEquals_DifferentObjectsId_AreNotEqual()
        {
            int i = 1;
            string snum = i.ToString();
            UsuarioView userA = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            i = 2;
            snum = (i + 1).ToString();
            UsuarioView userB = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            bool expected = true;
            bool actual = userA.Equals(userB);
            Assert.AreNotEqual(expected, actual);

        }

        ///</summary>
        [TestMethod()]
        //metodo Equals statico de object. Valores distintos (en objetos distintos) 
        public void StaticEquals_DifferentObjectsId_AreNotEqual()
        {
            int i = 1;
            string snum = i.ToString();
            UsuarioView userA = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            i = 2;
            snum = i.ToString();
            UsuarioView userB = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            bool expected = true;
            bool actual = object.Equals(userA, userB);
            Assert.AreNotEqual(expected, actual);

        }
        ///</summary>
        [TestMethod()]
        //sobre-escritura del operador == . Valores distintos (en objetos distintos) 
        public void OperatorEqual_DifferentObjetsId_AreNotEqual()
        {
            int i = 1;
            string snum = i.ToString();
            UsuarioView userA = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            i = 2;
            snum = (i + 1).ToString();
            UsuarioView userB = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            bool expected = true;
            bool actual = userA == userB;
            Assert.AreNotEqual(expected, actual);

        }

        [TestMethod()]
        //sobre-escritura del operador != . Valores distintos (en objetos distintos) 
        public void OperatorDistinct_DifferentObjectsId_AreNotEqual()
        {
            int i = 1;
            string snum = i.ToString();
            UsuarioView userA = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            i = 2;
            snum = (i + 1).ToString();
            UsuarioView userB = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            bool expected = false;
            bool actual = userA != userB;
            Assert.AreNotEqual(expected, actual);

        }
        #endregion


        #region Test de valores distintos por la derecha


        ///</summary>
        [TestMethod()]
        //sobre-escritura del metodo Equals. Valores distintos (en objetos distintos) 
        public void OverrideEqualsRight_DifferentObjectsId_AreNotEqual()
        {
            int i = 1;
            string snum = i.ToString();
            UsuarioView userA = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            i = 2;
            snum = (i + 1).ToString();
            UsuarioView userB = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            bool expected = true;
            bool actual = userB.Equals(userA);
            Assert.AreNotEqual(expected, actual);

        }

        ///</summary>
        [TestMethod()]
        //metodo Equals statico de object. Valores distintos (en objetos distintos) 
        public void StaticEqualsRight_DifferentObjectsId_AreNotEqual()
        {
            int i = 1;
            string snum = i.ToString();
            UsuarioView userA = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            i = 2;
            snum = i.ToString();
            UsuarioView userB = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            bool expected = true;
            bool actual = object.Equals(userB, userA);
            Assert.AreNotEqual(expected, actual);

        }
        ///</summary>
        [TestMethod()]
        //sobre-escritura del operador == . Valores distintos (en objetos distintos) 
        public void EqualOperatorRight_DifferentObjectsId_AreNotEqual()
        {
            int i = 1;
            string snum = i.ToString();
            UsuarioView userA = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            i = 2;
            snum = (i + 1).ToString();
            UsuarioView userB = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            bool expected = true;
            bool actual = userB == userA;
            Assert.AreNotEqual(expected, actual);

        }

        [TestMethod()]
        //sobre-escritura del operador != . Valores distintos (en objetos distintos) 
        public void DistinctOperator_DifferentObjectsId_AreNotEqual()
        {
            int i = 1;
            string snum = i.ToString();
            UsuarioView userA = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            i = 2;
            snum = (i + 1).ToString();
            UsuarioView userB = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            bool expected = false;
            bool actual = userB != userA;
            Assert.AreNotEqual(expected, actual);

        }
        #endregion


        #region Test de valores nulos
        ///</summary>
        [TestMethod()]
        //sobre-escritura del metodo Equals. 
        public void OverrideEquals_Null_AreNotEqual()
        {

            UsuarioView userA = null;

            int i = 1;
            string snum = i.ToString();
            UsuarioView userB = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            bool expected = true;
            bool actual = userB.Equals(userA);
            Assert.AreNotEqual(expected, actual);

        }


        ///</summary>
        [TestMethod()]
        //metodo Equals statico de object. valor nulo derecha 
        public void StaticEquals_NullRight_AreNotEqual()
        {
            //¿por qué este test lo pasa siempre?
            UsuarioView userA = null;

            int i = 1;
            string snum = i.ToString();
            UsuarioView userB = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            bool expected = true;
            bool actual = Equals(userB, userA);
            Assert.AreNotEqual(expected, actual);

        }


        ///</summary>
        [TestMethod()]
        //metodo Equals statico de object. valor nulo izquierda 
        public void StaticEquals_NullLeft_AreNotEqual()
        {
            //¿por qué este test lo pasa siempre?

            UsuarioView userA = null;

            int i = 1;
            string snum = i.ToString();
            UsuarioView userB = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            bool expected = true;
            bool actual = Equals(userA, userB);
            Assert.AreNotEqual(expected, actual);

        }

        ///</summary>
        [TestMethod()]
        //metodo Equals statico de object. valor nulo en ambos 
        public void StaticEquals_Nullboth_AreEqual()
        {
            //¿por qué este test lo pasa siempre?
            UsuarioView userA = null;
            UsuarioView userB = null;


            bool expected = true;
            bool actual = Equals(userA, userB);
            Assert.AreEqual(expected, actual);

        }

        ///</summary>
        [TestMethod()]
        //operador == . valor nulo izquierda 
        public void OperatorEquals_NullLeft_AreNotEqual()
        {

            UsuarioView userA = null;

            int i = 1;
            string snum = i.ToString();
            UsuarioView userB = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            bool expected = true;
            bool actual = userA == userB;
            Assert.AreNotEqual(expected, actual);

        }

        ///</summary>
        [TestMethod()]
        //operador == . valor nulo derecha 
        public void OperatorEquals_NullRight_AreNotEqual()
        {

            UsuarioView userA = null;

            int i = 1;
            string snum = i.ToString();
            UsuarioView userB = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            bool expected = true;
            bool actual = userB == userA;
            Assert.AreNotEqual(expected, actual);

        }

        ///</summary>
        [TestMethod()]
        //operador == . ambos nulos
        public void OperatorEquals_Nullboth_AreEqual()
        {

            UsuarioView userA = null;
            UsuarioView userB = null;

            bool expected = true;
            bool actual = userB == userA;
            Assert.AreEqual(expected, actual);

        }
        ///</summary>
        [TestMethod()]
        //operador != . valor nulo izquierda 
        public void OperatorDistinct_NullLeft_AreNotEqual()
        {

            UsuarioView userA = null;

            int i = 1;
            string snum = i.ToString();
            UsuarioView userB = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            bool expected = false;
            bool actual = userA != userB;
            Assert.AreNotEqual(expected, actual);

        }

        ///</summary>
        [TestMethod()]
        //operador != . valor nulo derecha 
        public void OperatorDistinct_NullRight_AreNotEqual()
        {

            UsuarioView userA = null;

            int i = 1;
            string snum = i.ToString();
            UsuarioView userB = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            bool expected = false;
            bool actual = userB != userA;
            Assert.AreNotEqual(expected, actual);

        }


        ///</summary>
        [TestMethod()]
        //operador != . ambos nulos
        public void OperatorDistinct_Nullboth_AreEqual()
        {

            UsuarioView userA = null;
            UsuarioView userB = null;

            bool expected = false;
            bool actual = userB != userA;
            Assert.AreEqual(expected, actual);

        }



        #endregion


        #region Hashcodes
        ///</summary>
        [TestMethod()]
        //metodo getHashCode. el mismo valor en objetos distintos  
        public void GetHashCode_DifferentObjectsWithSameId_AreEqual()
        {

            int i = 1;
            string snum = i.ToString();
            UsuarioView userA = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            i = 1;
            snum = (i + 1).ToString();
            UsuarioView userB = new UsuarioView(i, "nombre_" + snum, "palabrapaso_" + snum, "roll_" + snum, true);

            int expected = userA.GetHashCode();
            int actual = userB.GetHashCode();

            Assert.AreEqual(expected, actual);

        }
        #endregion



    }
}
