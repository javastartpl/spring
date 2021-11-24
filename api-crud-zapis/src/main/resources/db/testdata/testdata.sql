INSERT INTO
    company (name, description, city, employees, telephone, email)
VALUES
    ('Appul', 'Jesteśmy innowacyjną firmą z tradycjami, tworzymy oprogramowanie od ponad 20 lat', 'Wrocław', 100,
     '48 123-234-345', 'kontakt@appul.xyz'),
    ('Gugiel', 'Lider w branży oprogramowania dla małych i średnich firm', 'Warszawa', 300,
     '48 999-888-777', 'hello@gugiel.com');
INSERT INTO
    job_offer (title, description, requirements, duties, location, min_salary, max_salary, date_added, submissions, company_id)
VALUES
    ('Senior java developer', 'Dołącz do naszego zespołu i twórz nowoczesne aplikacje',
     '2 lata doświadczenia w programowaniu w Javie 8+. Znajomość frameworków Spring i Hibernate',
     'Rozwój istniejącej aplikacji webowej tworzonej dla jednego ze sklepów wielkopowoerzchniowych',
     'Wrocław', 5000, 9000, '2021-01-01 12:00:00', 22, 1),
    ('Python developer', 'Twórz aplikacje dla czołowych firm MSP',
     'Wymagamy dobrej znajomości Pythona i frameworka Django, a także relacyjnych baz danych, HTML, CSS i JavaScriptu',
     'Będziesz odpowiadał za rozwój nowej aplikacji dla klienta z sektora finansów',
     'Warszawa', 7000, 12000, '2021-02-01 12:00:00', 33, 1),
    ('Devops engineer', 'Dołącz do nas i rozwijaj aplikacje dla najlepszych',
     'Znajomość Dockera, Kubernetesa i Jenkinsa, umiejętność pracy w metodologii Agile',
     'Będziesz odpowiedzialny za wdrozenie procesu ciągłej integracji w jednym z naszych kluczowych projektów',
     'Warszawa', 7000, 12000, '2021-02-01 12:00:00', 11, 2);
