# LTL

How to use it:

Adds the following dependency and repository in your POM.xml

```
<repository>
			<id>LTL-mvn-repo</id>
			<url>https://raw.github.com/claudiomenghi/LTL/mvn-repo/</url>
			<snapshots>
				<enabled>true</enabled>
				<updatePolicy>always</updatePolicy>
			</snapshots>
		</repository>

	<dependency>
			<groupId>se.gu</groupId>
			<artifactId>LTL</artifactId>
			<version>0.0.1-SNAPSHOT</version>
		</dependency>

```