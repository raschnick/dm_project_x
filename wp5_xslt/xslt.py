import lxml.etree as ET

dom = ET.parse("data/data.xml")
xslt = ET.parse("transform.xsl")
transform = ET.XSLT(xslt)
newdom = transform(dom)

f = open("output/index.html", "w")
f.write(ET.tostring(newdom, pretty_print=True).decode("utf-8"))
f.close()

# log
print(ET.tostring(newdom, pretty_print=True).decode("utf-8"))