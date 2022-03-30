insert into users (username, password)
values (
  'kispista',
  'teszt'
);
insert into unit_type (unit_type_name)
values ('db');
insert into unit_type (unit_type_name)
values ('km');
insert into stat_category (stat_category_name)
values ('Edzés');
insert into stat (stat_name, unit_type_id, stat_category_id, user_id)
values (
  'Felülés',
  (
    select id
    from unit_type
    where unit_type_name = 'db'
  ),
  (
    select id
    from stat_category
    where stat_category_name = 'Edzés'
  ),
  (
    select id
    from users
    where username = 'kispista'
  )
);
insert into progress (stat_id, progress_value)
values (
  (
    select id
    from stat
    where (
      stat_name = 'Felülés'
      and user_id = (
        select id
        from users
        where username = 'kispista'
      )
    )
  ),
  10
);
insert into progress (stat_id, progress_value)
values (
  (
    select id
    from stat
    where (
      stat_name = 'Felülés'
      and user_id = (
        select id
        from users
        where username = 'kispista'
      )
    )
  ),
  15
);
insert into progress (stat_id, progress_value)
values (
  (
    select id
    from stat
    where (
      stat_name = 'Felülés'
      and user_id = (
        select id
        from users
        where username = 'kispista'
      )
    )
  ),
  16
);
insert into progress (stat_id, progress_value)
values (
  (
    select id
    from stat
    where (
      stat_name = 'Felülés'
      and user_id = (
        select id
        from users
        where username = 'kispista'
      )
    )
  ),
  10
);
insert into goal (title, goal_value, goal_logic)
values (
  'Csinálj 30 felülést',
  30,
  '=>'
);
insert into goal_stat (goal_id, stat_id)
values (
  (
    select id
    from goal
    where title = 'Csinálj 30 felülést'
  ),
  (
    select id
    from stat
    where (
      stat_name = 'Felülés'
      and user_id = (
        select id
        from users
        where username = 'kispista'
      )
    )
  )
);