<h2 style="text-align:center">Android GUI Component Identifier</h2>
<h3 style="text-align:center">CSCI 435 Project 0</h3>

<h4>Description of Solution</h4>

<p>For this project, the program begins by creating a directory for the output and reading in the path name of the XML files from the data directory. These XML files are then parsed, their leaf-level components are identified, and the bound attribute for each of their leaf-level nodes are translated into a list of coordinates for each rectangle to highlight the GUI component. This list of rectangle coordinates are then given to a 2D image editor to be drawn onto the PNG file from the data directory and are saved in the output directory. This loop repeats for all of the XML files in the data directory.</p>

<h4>Design Decisions</h4>

<p>To make this tool, I decided to use Java because I am very familiar with this programming language, thought object-oriented programming suited this project, and knew Java had a lot of built-in libraries that I could use. I did have to find a lot of information on some libraries, Android, and XML files though, because I did not have a lot of experience with Android or XML files. The libraries I used include <a href="https://docs.oracle.com/javase/8/docs/api/index.html?javax/xml/parsers/package-summary.html">JavaX XML Parses</a>, <a href="https://docs.oracle.com/javase/7/docs/api/javax/xml/xpath/package-summary.html">JavaX XML XPath</a>, and a <a href="https://docs.oracle.com/javase/8/docs/api/index.html?org/w3c/dom/package-summary.html">built-in Java DOM library</a>.</p> 

<p>I wanted to ensure that I only delegated one responsibility to each class, so I made 3 classes for this repository: GuiComponentIdentifier, LeafNodeIdentifier, and RectCoordinates. As each title insinuates, the first class identifies the components on the GUI, the second class identifies the leaf node components, and third class contains/computes the coordinates for the rectangle to be drawn. The main function is in GuiComponentIdentifier since this is the main task/responsibility of the program.</p>

<p>Lastly, to distinguish between the provided set of PNG and XML files and the output, I decided to make the tool produce a new directory with the output at the beginning of the program. The annotated screenshots in this output directory have the same name as the ones in the data directory.</p>

<h4>How to Use</h4>

<ol>
<li>Clone the repository</li>
<li>Delete the output directory</li>
<li>Run the main method in GuiComponentIdentifier</li>
</ol>

<p><em>Note: When I cloned this repository and followed the 3 steps above, my imports from RectCoordinates and LeafNodeIdentifier to GuiComponentIdentifier were still showing as errors, but I ran the main method from GuiComponentIdentifier and still had got successful output depsite those errors and an additional output in the console that said there was an error creating the output directory. I'm not sure why this happened, but the program still worked.</em></p>

<h4>Resources/Citations</h4>

<ul>
<li><a href="https://www.w3schools.com/xml/xml_tree.asp">XML File Structure</a></li>
<li><a href="https://mkyong.com/java/how-to-read-xml-file-in-java-dom-parser/">How to Read an XML File in Java</a></li>
<li><a href="https://www.baeldung.com/java-xpath">Java XPath Library</a></li>
<li><a href="https://howtodoinjava.com/java/xml/java-xpath-expression-examples/">XPath Expressions Tutorial</a></li>
<li><a href="https://stackoverflow.com/questions/20783506/get-leaf-nodes-xml-parsing-in-java">Finding XML Leaf Nodes</a></li>
<li><a href="https://docs.oracle.com/javase/6/docs/api/java/awt/Graphics2D.html">Graphics2D Library</a></li>
</ul>
