<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

    <xsl:template match="/">
        <html>
            <head>
                <title>Nodes</title>
                <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
                      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
                      crossorigin="anonymous"/>
            </head>

            <body>
                <div class="container">
                    <div>
                        <h1>A Table of Nodes</h1>
                    </div>
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">Type</th>
                                <th scope="col">Name</th>
                            </tr>
                        </thead>
                        <tbody>
                            <xsl:for-each select="dataset/nodes/node">
                                <tr>
                                    <td>
                                        <xsl:value-of select="id"/>
                                    </td>
                                    <td>
                                        <xsl:value-of select="dtype"/>
                                    </td>
                                    <td>
                                        <xsl:value-of select="name"/>
                                    </td>
                                </tr>
                            </xsl:for-each>
                        </tbody>
                    </table>
                </div>

                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
                        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
                        crossorigin="anonymous"/>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
