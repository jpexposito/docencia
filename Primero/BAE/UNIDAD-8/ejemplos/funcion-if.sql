<div align="justify">

# Ejemplo de sentencia if en funciones

```sql
drop function if exists existe_tabla;
delimiter //
create function existe_tabla(nombreBD varchar(100), nombreTabla varchar(100))
returns boolean
-- DETERMINISTIC
-- READS SQL DATA 
-- MODIFIES SQL DATA
begin
	declare resultado Boolean default 0;
	if nombreBD is null or nombreTabla is null or length(nombreBD)=0 or length(nombreTabla)=0 then
		return resultado;
    end if;
    set resultado = exists(select table_name from information_schema.tables where table_name=nombreTabla and table_Schema=nombreBD);
    return resultado;
end//
delimiter ;

select existe_tabla('BD06','usuario');
```
</div>