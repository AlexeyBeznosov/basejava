package ru.javawebinar.basejava;

import ru.javawebinar.basejava.model.*;

import java.time.LocalDate;

public class ResumeTestData {

    public static void main(String[] args) {
        Resume resume = new Resume("Григорий Кислин");
        resume.addContact("Тел.: ","+7(921) 855-0482");
        resume.addContact("Skype: ","grigory.kislin");
        resume.addContact("Почта: ","gkislin@yandex.ru");
        resume.addContact("Профиль LinkedIn", "");
        resume.addContact("Профиль GitHub", "");
        resume.addContact("Профиль Stackoverflow", "");
        resume.addContact("Домашняя страница", "");

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
        String title = "Java Online Projects";
        String text = "Автор проекта.\n" +
                "Создание, организация и проведение Java онлайн проектов и стажировок.";
        Object[] objects = new Object[]{title, dateOfBegin, dateOfEnd, text};
        resume.fillSection(SectionType.EXPERIENCE, objects);
        dateOfBegin = LocalDate.of(2014, 10, 1);
        dateOfEnd = LocalDate.of(2016, 1, 1);
        title = "Wrike";
        text = "Старший разработчик (backend)\n" +
                "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.";
        objects[0] = title;
        objects[1] = dateOfBegin;
        objects[2] = dateOfEnd;
        objects[3] = text;
        resume.fillSection(SectionType.EXPERIENCE, objects);
        dateOfBegin = LocalDate.of(2012, 4, 1);
        dateOfEnd = LocalDate.of(2014, 10, 1);
        title = "RIT Center";
        text = "Java архитектор\n" +
                "Организация процесса разработки системы ERP для разных окружений: релизная политика, версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python";
        objects[0] = title;
        objects[1] = dateOfBegin;
        objects[2] = dateOfEnd;
        objects[3] = text;
        resume.fillSection(SectionType.EXPERIENCE, objects);
        dateOfBegin = LocalDate.of(2010, 12, 1);
        dateOfEnd = LocalDate.of(2012, 4, 1);
        title = "Luxoft (Deutsche Bank)";
        text = "Ведущий программист\n" +
                "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM. Реализация RIA-приложения для администрирования, мониторинга и анализа результатов в области алгоритмического трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5.";
        objects[0] = title;
        objects[1] = dateOfBegin;
        objects[2] = dateOfEnd;
        objects[3] = text;
        resume.fillSection(SectionType.EXPERIENCE, objects);
        dateOfBegin = LocalDate.of(2008, 6, 1);
        dateOfEnd = LocalDate.of(2010, 12, 1);
        title = "Yota";
        text = "Ведущий специалист\n" +
                "Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). Реализация администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента (Python/ Jython, Django, ExtJS)";
        objects[0] = title;
        objects[1] = dateOfBegin;
        objects[2] = dateOfEnd;
        objects[3] = text;
        resume.fillSection(SectionType.EXPERIENCE, objects);
        dateOfBegin = LocalDate.of(2007, 3, 1);
        dateOfEnd = LocalDate.of(2008, 6, 1);
        title = "Enkata";
        text = "Разработчик ПО\n" +
                "Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining).";
        objects[0] = title;
        objects[1] = dateOfBegin;
        objects[2] = dateOfEnd;
        objects[3] = text;
        resume.fillSection(SectionType.EXPERIENCE, objects);
        dateOfBegin = LocalDate.of(2005, 1, 1);
        dateOfEnd = LocalDate.of(2007, 2, 1);
        title = "Siemens AG";
        text = "Разработчик ПО\n" +
                "Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix).";
        objects[0] = title;
        objects[1] = dateOfBegin;
        objects[2] = dateOfEnd;
        objects[3] = text;
        resume.fillSection(SectionType.EXPERIENCE, objects);
        dateOfBegin = LocalDate.of(1997, 9, 1);
        dateOfEnd = LocalDate.of(2005, 1, 1);
        title = "Alcatel";
        text = "Инженер по аппаратному и программному тестированию\n" +
                "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM).";
        objects[0] = title;
        objects[1] = dateOfBegin;
        objects[2] = dateOfEnd;
        objects[3] = text;
        resume.fillSection(SectionType.EXPERIENCE, objects);

        dateOfBegin = LocalDate.of(2013, 3, 1);
        dateOfEnd = LocalDate.of(2013, 5, 1);;
        title = "Coursera";
        text = "\"Functional Programming Principles in Scala\" by Martin Odersky";
        objects = new Object[]{title, dateOfBegin, dateOfEnd, text};
        resume.fillSection(SectionType.EDUCATION, objects);
        dateOfBegin = LocalDate.of(2011, 3, 1);
        dateOfEnd = LocalDate.of(2011, 4, 1);;
        title = "Luxoft";
        text = "Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\"";
        objects = new Object[]{title, dateOfBegin, dateOfEnd, text};
        resume.fillSection(SectionType.EDUCATION, objects);
        dateOfBegin = LocalDate.of(2005, 1, 1);
        dateOfEnd = LocalDate.of(2005, 4, 1);;
        title = "Siemens AG";
        text = "3 месяца обучения мобильным IN сетям (Берлин)";
        objects = new Object[]{title, dateOfBegin, dateOfEnd, text};
        resume.fillSection(SectionType.EDUCATION, objects);
        dateOfBegin = LocalDate.of(1997, 9, 1);
        dateOfEnd = LocalDate.of(1998, 3, 1);;
        title = "Alcatel";
        text = "6 месяцев обучения цифровым телефонным сетям (Москва)";
        objects = new Object[]{title, dateOfBegin, dateOfEnd, text};
        resume.fillSection(SectionType.EDUCATION, objects);
        dateOfBegin = LocalDate.of(1993, 9, 1);
        dateOfEnd = LocalDate.of(1996, 7, 1);;
        title = "Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики";
        text = "Аспирантура (программист С, С++)";
        objects = new Object[]{title, dateOfBegin, dateOfEnd, text};
        resume.fillSection(SectionType.EDUCATION, objects);
        dateOfBegin = LocalDate.of(1987, 9, 1);
        dateOfEnd = LocalDate.of(1993, 7, 1);;
        title = "Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики";
        text = "Инженер (программист Fortran, C)";
        objects = new Object[]{title, dateOfBegin, dateOfEnd, text};
        resume.fillSection(SectionType.EDUCATION, objects);
        dateOfBegin = LocalDate.of(1984, 9, 1);
        dateOfEnd = LocalDate.of(1987, 6, 1);;
        title = "Заочная физико-техническая школа при МФТИ";
        text = "Закончил с отличием";
        objects = new Object[]{title, dateOfBegin, dateOfEnd, text};
        resume.fillSection(SectionType.EDUCATION, objects);
    }
}
