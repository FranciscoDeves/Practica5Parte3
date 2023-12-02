// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false

   //añadido en el gradle del app, si no no me coge
   //val action=ListaFragmentDirections.actionEditar(tarea) y me sale en rojo ListaFragmentDirections
//    id ("androidx.navigation.safeargs.kotlin") version "2.7.4" apply false

}

buildscript {
    repositories {
        google()
    }
    dependencies {
        val nav_version = "2.7.4"
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version")
    }
}