

### Tools needed

* Eclipse (Used Juno, but should work with others as well)
* m2e-wtp

### Getting started

1) Import this as a maven project
2) Maven build: package
3) Refresh your project files
4) Start superdevmode server by right-clicking SuperDevMode.launch and chooosing Run As > SuperDevMode
5) If using Chrome (recommended), open development tools and click settings icon (bottom right). Ensure that General > Source Maps is checked. 
6) If using JRebel (recommended), right-click project and choose JRebel > Add JRebel Nature
7) Start server by right-clicking your project and choosing Debug As > Debug on Server
8) Navigate to http://localhost:8080/<your project name>/?superdevmode

Enjoy. When you are refreshing the page, observe that widgetset is recompiled in <10sec. Also observe that server-side changes get deployed in under <1sec and thus edit-see cycle is minimal.