# alertpage af EMC

Denne readme fil beskriver de centrale filer i applikationen og hvordan, de er forbundet. 

GWT-MODULE - TmpPageDashboard.gwt.xlm (src/):
Heri angives bl.a. de externe moduler, der skal loades, extern CSS og entry point. Der anvendes GwtBoostrap3Theme module og customized Bootstrap.css filer.

Public css - bootstrap.css, boostrap-theme.css & tableStyle.css (scr/public/):
Disse CSS-filer injectes, så de er tilgængelige i java classes. 

Entry Point - TmpPageDashboard.java (scr/client/):
Denne java class indeholder onModuleLoad(), som indsætter de java-classes, der udgør siden. Det loades ind v.h.a. RootPanel(). Desuden injectes css-fil "mainStyle_From_Resources.css", 
som primært er gjort fordi, jeg gerne ville forstå, hvordan dette kunne gøres. 

Navigation Bar - navBarViewer.java, navBarViewer.ui.xml & styleNavBar.css (scr/client/):
.java-filen initer navBarViwer.xlm gennem UI-binder fra GWT. Alle elementer er statistiske, så der er ikke andre funktioner i navBarViewer.java. navBarViewer.xml anvender
styleNavBar.css til at customize bootstrap navBar, så den ligner vores nuværende navigationsbar. 

Information Widgets - tmpPageViewer.java, tmpPageViewer.ui.xml, styleTmpPage.css (scr/client/):
.java-filen initer de øverste fire små widgets, target bars widget og "top 5 recommendation widget". Desuden fremstiller den data, der ligger til grund for target bar.
Endvidere sørger den for, at collapse-icon for target bar widget og top 5 recommendation widget ændrer sig, når de to collapses. Fungerer gennem UI-binder.

Alert Table Widget - simpleTable.java, simpleTable.ui.xml & CellTable.css (scr/client/):
.java-filen fremstiller data til tabellen og indlæser dette. Desuden tilføres customized CSS til CellTable.Resources, så tabellens udseende kan brugerdefineres. Til sidst indføres conditional formatting af alert status kolonne. 

Resources - Resources.java (scr/client/) & mainStyle_From_Resources (scr/Resopurces/):
Denne .java-fil gør det muligt at "binde" css-filer fra scr/Resources hen til i client filerne. Sker gennem ClientBinder approach. Bliver kun brugt til at ændre baggrundsfarven for hele applikationen. 

Server files - GreetingServiceImpl.java (scr/server):
Denne fil blev automatisk dannet, da jeg anvendte GWT-plugin i Eclipse. Den har ingen funktion, men jeg kan ikke deploy på en test-server, hvis den ikke er tilstede. Jeg kan ikke finde ud af, hvorfor dette er tilfældet. 

External Libraries (JARS) - gwtboostrap3-0.9.4.jar & GWT SDK [gwt-2.8.1-2.8.1]:
Her behøver vist ingen forklaring. 

WAR - TmpPageDashobard.html(scr/war)
TmpPageDashboard.html har intet indhold i body. Angiver blot titlen på applikationen. 

