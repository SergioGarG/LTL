# This repository contains the LTL classes that support the usage of LTL

This project is associated with a maven dependency that allows to use the patterns within your project.

To use it add this repository and dependency in your POM.xml

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

LTL formula can be then used as follows.

```
LTLFormula formula=new LTLGlobally(new LTLImplies(new LTLPCAtom(fastReaction.getCondition()),
				new LTLNext(new LTLPAAtom(fastReaction.getLocation())))
```

LTL formula  can be converted into different formats. To convert it in NuSMV

```
String nusmvRep= formula.accept(new LTL2NuSMV());
```

To  see how for example robotic patterns can be converted in LTL formula see [https://github.com/claudiomenghi/Patterns](https://github.com/claudiomenghi/Patterns)