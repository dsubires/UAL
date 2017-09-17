using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

using dsp086.Practica_02;
using System.Collections.Generic;


namespace dsp086.Practica_02
{
    [TestClass]
    public class TestHash
    {
        [TestMethod]
        public void Constructor_WithNoParams_IsNotNull()
        {
            HashSet<UsuarioView> hash = new HashSet<UsuarioView>();
            Assert.IsNotNull(hash);
        }

        [TestMethod]
        public void Contains_AddedObject_IsTrue()
        {
            HashSet<UsuarioView> hash = new HashSet<UsuarioView>();
            UsuarioView user = new UsuarioView(1, "user-1", "pass-1", "alumno", true);
            hash.Add(user);
            Assert.IsTrue(hash.Contains(user));
        }

        [TestMethod]
        public void Contains_DifferentObjectWithSameId_IsTrue()
        {
            HashSet<UsuarioView> hash = new HashSet<UsuarioView>();
            UsuarioView user = new UsuarioView(1, "user-1", "pass-1", "alumno", true);
            hash.Add(user);
            var usercopia = new UsuarioView(1, "user-1", "pass-1", "alumno", true);

            Assert.IsTrue(hash.Contains(usercopia));
        }


    }
}
