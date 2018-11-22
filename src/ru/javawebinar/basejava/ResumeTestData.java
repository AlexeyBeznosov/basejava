package ru.javawebinar.basejava;

import ru.javawebinar.basejava.model.*;

import java.time.LocalDate;

public class ResumeTestData {

    public static void main(String[] args) {
        Resume resume = new Resume("Григорий Кислин");
        resume.addContact(ContactType.PHON_NUMBER,"Тел.: +7(921) 855-0482","");
        resume.addContact(ContactType.SKYPE,"Skype: grigory.kislin","skype:grigory.kislin");
        resume.addContact(ContactType.EMAIL,"Почта: gkislin@yandex.ru","mailto:gkislin@yandex.ru");
        resume.addContact(ContactType.LINKEDIN,"Профиль LinkedIn","https://www.linkedin.com/in/gkislin");
        resume.addContact(ContactType.GITHUB,"Профиль GitHub","https://github.com/gkislin");
        resume.addContact(ContactType.STACKOVERFLOW,"Профиль Stackoverflow","https://stackoverflow.com/users/548473");
        resume.addContact(ContactType.HOME_PAGE,"Домашняя страница","http://gkislin.ru/");

        resume.addSection(SectionType.OBJECTIVE);
        resume.addSection(SectionType.PERSONAL);
        resume.addSection(SectionType.ACHIEVEMENT);
        resume.addSection(SectionType.QUALIFICATIONS);
        resume.addSection(SectionType.EXPERIENCE);
        resume.addSection(SectionType.EDUCATION);

        String[] strings = new String[]{"Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям"};
        resume.fillSection(SectionType.OBJECTIVE, strings);

        strings[0] = "Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры.";
        resume.fillSection(SectionType.PERSONAL, strings);

        strings[0] = "С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 1000 выпускников.";
        resume.fillSection(SectionType.ACHIEVEMENT, strings);
        strings[0] = "Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.";
        resume.fillSection(SectionType.ACHIEVEMENT, strings);
        strings[0] = "Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера.";
        resume.fillSection(SectionType.ACHIEVEMENT, strings);
        strings[0] = "Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.";
        resume.fillSection(SectionType.ACHIEVEMENT, strings);
        strings[0] = "Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).";
        resume.fillSection(SectionType.ACHIEVEMENT, strings);
        strings[0] = "Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа.";
        resume.fillSection(SectionType.ACHIEVEMENT, strings);

        strings[0] = "JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2";
        resume.fillSection(SectionType.QUALIFICATIONS, strings);
        strings[0] = "Version control: Subversion, Git, Mercury, ClearCase, Perforce";
        resume.fillSection(SectionType.QUALIFICATIONS, strings);
        strings[0] = "DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle,";
        resume.fillSection(SectionType.QUALIFICATIONS, strings);
        strings[0] = "MySQL, SQLite, MS SQL, HSQLDB";
        resume.fillSection(SectionType.QUALIFICATIONS, strings);
        strings[0] = "Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy,";
        resume.fillSection(SectionType.QUALIFICATIONS, strings);
        strings[0] = "XML/XSD/XSLT, SQL, C/C++, Unix shell scripts,";
        resume.fillSection(SectionType.QUALIFICATIONS, strings);
        strings[0] = "Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring (MVC, Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements).";
        resume.fillSection(SectionType.QUALIFICATIONS, strings);
        strings[0] = "Python: Django.";
        resume.fillSection(SectionType.QUALIFICATIONS, strings);
        strings[0] = "JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js";
        resume.fillSection(SectionType.QUALIFICATIONS, strings);
        strings[0] = "Scala: SBT, Play2, Specs2, Anorm, Spray, Akka";
        resume.fillSection(SectionType.QUALIFICATIONS, strings);
        strings[0] = "Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT.";
        resume.fillSection(SectionType.QUALIFICATIONS, strings);
        strings[0] = "Инструменты: Maven + plugin development, Gradle, настройка Ngnix,";
        resume.fillSection(SectionType.QUALIFICATIONS, strings);
        strings[0] = "администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer.";
        resume.fillSection(SectionType.QUALIFICATIONS, strings);
        strings[0] = "Отличное знание и опыт применения концепций ООП, SOA, шаблонов";
        resume.fillSection(SectionType.QUALIFICATIONS, strings);
        strings[0] = "проектрирования, архитектурных шаблонов, UML, функционального программирования";
        resume.fillSection(SectionType.QUALIFICATIONS, strings);
        strings[0] = "Родной русский, английский \"upper intermediate\"";
        resume.fillSection(SectionType.QUALIFICATIONS, strings);

        LocalDate dateOfBegin = LocalDate.of(2013, 10, 1);
        LocalDate dateOfEnd = null;
        Object[] objects = new Object[]{"Java Online Projects", "http://javaops.ru/", dateOfBegin, dateOfEnd, "Автор проекта.", "Создание, организация и проведение Java онлайн проектов и стажировок."};
        resume.fillSection(SectionType.EXPERIENCE, objects);
        dateOfBegin = LocalDate.of(2014, 10, 1);
        dateOfEnd = LocalDate.of(2016, 1, 1);
        objects[0] = "Wrike";
        objects[1] = "https://www.wrike.com/";
        objects[2] = dateOfBegin;
        objects[3] = dateOfEnd;
        objects[4] = "Старший разработчик (backend)";
        objects[5] = "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.";
        resume.fillSection(SectionType.EXPERIENCE, objects);
        dateOfBegin = LocalDate.of(2012, 4, 1);
        dateOfEnd = LocalDate.of(2014, 10, 1);
        objects[0] = "RIT Center";
        objects[1] = "";
        objects[2] = dateOfBegin;
        objects[3] = dateOfEnd;
        objects[4] = "Java архитектор";
        objects[5] = "Организация процесса разработки системы ERP для разных окружений: релизная политика, версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python";
        resume.fillSection(SectionType.EXPERIENCE, objects);
        dateOfBegin = LocalDate.of(2010, 12, 1);
        dateOfEnd = LocalDate.of(2012, 4, 1);
        objects[0] = "Luxoft (Deutsche Bank)";
        objects[1] = "http://www.luxoft.ru/";
        objects[2] = dateOfBegin;
        objects[3] = dateOfEnd;
        objects[4] = "Ведущий программист";
        objects[5] = "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM. Реализация RIA-приложения для администрирования, мониторинга и анализа результатов в области алгоритмического трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5.";
        resume.fillSection(SectionType.EXPERIENCE, objects);
        dateOfBegin = LocalDate.of(2008, 6, 1);
        dateOfEnd = LocalDate.of(2010, 12, 1);
        objects[0] = "Yota";
        objects[1] = "https://www.yota.ru/";
        objects[2] = dateOfBegin;
        objects[3] = dateOfEnd;
        objects[4] = "Ведущий специалист";
        objects[5] = "Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). Реализация администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента (Python/ Jython, Django, ExtJS)";
        resume.fillSection(SectionType.EXPERIENCE, objects);
        dateOfBegin = LocalDate.of(2007, 3, 1);
        dateOfEnd = LocalDate.of(2008, 6, 1);
        objects[0] = "Enkata";
        objects[1] = "http://enkata.com/";
        objects[2] = dateOfBegin;
        objects[3] = dateOfEnd;
        objects[4] = "Разработчик ПО";
        objects[5] = "Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining).";
        resume.fillSection(SectionType.EXPERIENCE, objects);
        dateOfBegin = LocalDate.of(2005, 1, 1);
        dateOfEnd = LocalDate.of(2007, 2, 1);
        objects[0] = "Siemens AG";
        objects[1] = "https://www.siemens.com/ru/ru/home.html";
        objects[2] = dateOfBegin;
        objects[3] = dateOfEnd;
        objects[4] = "Разработчик ПО";
        objects[5] = "Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix).";
        resume.fillSection(SectionType.EXPERIENCE, objects);
        dateOfBegin = LocalDate.of(1997, 9, 1);
        dateOfEnd = LocalDate.of(2005, 1, 1);
        objects[0] = "Alcatel";
        objects[1] = "http://www.alcatel.ru/";
        objects[2] = dateOfBegin;
        objects[3] = dateOfEnd;
        objects[4] = "Инженер по аппаратному и программному тестированию";
        objects[5] = "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM).";
        resume.fillSection(SectionType.EXPERIENCE, objects);

        dateOfBegin = LocalDate.of(2013, 3, 1);
        dateOfEnd = LocalDate.of(2013, 5, 1);
        objects[0] = "Coursera";
        objects[1] = "https://www.coursera.org/course/progfun";
        objects[2] = dateOfBegin;
        objects[3] = dateOfEnd;
        objects[4] = "\"Functional Programming Principles in Scala\" by Martin Odersky";
        objects[5] = "";
        resume.fillSection(SectionType.EDUCATION, objects);
        dateOfBegin = LocalDate.of(2011, 3, 1);
        dateOfEnd = LocalDate.of(2011, 4, 1);
        objects[0] = "Luxoft";
        objects[1] = "http://www.luxoft-training.ru/training/catalog/course.html?ID=22366";
        objects[2] = dateOfBegin;
        objects[3] = dateOfEnd;
        objects[4] = "Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\"";
        objects[5] = "";
        resume.fillSection(SectionType.EDUCATION, objects);
        dateOfBegin = LocalDate.of(2005, 1, 1);
        dateOfEnd = LocalDate.of(2005, 4, 1);
        objects[0] = "Siemens AG";
        objects[1] = "http://www.siemens.ru/";
        objects[2] = dateOfBegin;
        objects[3] = dateOfEnd;
        objects[4] = "3 месяца обучения мобильным IN сетям (Берлин)";
        objects[5] = "";
        resume.fillSection(SectionType.EDUCATION, objects);
        dateOfBegin = LocalDate.of(1997, 9, 1);
        dateOfEnd = LocalDate.of(1998, 3, 1);
        objects[0] = "Alcatel";
        objects[1] = "http://www.alcatel.ru/";
        objects[2] = dateOfBegin;
        objects[3] = dateOfEnd;
        objects[4] = "6 месяцев обучения цифровым телефонным сетям (Москва)";
        objects[5] = "";
        resume.fillSection(SectionType.EDUCATION, objects);
        dateOfBegin = LocalDate.of(1993, 9, 1);
        dateOfEnd = LocalDate.of(1996, 7, 1);;
        objects[0] = "Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики";
        objects[1] = "http://www.ifmo.ru/";
        objects[2] = dateOfBegin;
        objects[3] = dateOfEnd;
        objects[4] = "Аспирантура (программист С, С++)";
        objects[5] = "";
        resume.fillSection(SectionType.EDUCATION, objects);
        dateOfBegin = LocalDate.of(1987, 9, 1);
        dateOfEnd = LocalDate.of(1993, 7, 1);
        objects[0] = "Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики";
        objects[1] = "http://www.ifmo.ru/";
        objects[2] = dateOfBegin;
        objects[3] = dateOfEnd;
        objects[4] = "Инженер (программист Fortran, C)";
        objects[5] = "";
        resume.fillSection(SectionType.EDUCATION, objects);
        dateOfBegin = LocalDate.of(1984, 9, 1);
        dateOfEnd = LocalDate.of(1987, 6, 1);
        objects[0] = "Заочная физико-техническая школа при МФТИ";
        objects[1] = "http://www.school.mipt.ru/";
        objects[2] = dateOfBegin;
        objects[3] = dateOfEnd;
        objects[4] = "Закончил с отличием";
        objects[5] = "";
        resume.fillSection(SectionType.EDUCATION, objects);
    }
}