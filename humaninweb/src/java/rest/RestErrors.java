public interface RestErrors{

    int OK = 0; // Код успешного завершения

    int UNSUPPORTED = -1; // Ошибка возникает, когда номер команды, к которой производится обращение, отсутствует среди
    // значений констант, приведённых в файле RestActions.java, либо когда та или иная команда на данный момент времени
    // пока ещё не создана

    int TYPE_MISMATCH_ERROR = -2; // Ошибка возникает, когда то или иное поле, необходимое для успешного выполнения команды,
    // или не получено от клиента, либо содержит данные, представленные в неверном формате

    int AUTH_ERROR = -3; // Ошибка возникает, когда у пользователя или посетителя отсутствуют полномочия, необходимые
    // для совершения запрашиваемой операции

    int FREE_VERSION_ERROR = -4; // Ошибка возникает, когда Администратор запрашивает действие, доступное в платной
    // версии приложения

    int POLITICIAN_NOT_FOUND = -5; // Политик не найден
    int USER_NOT_FOUND = -6; // Пользователь не найден
    int SITE_NOT_FOUND = -7; // Новостной сайт не найден

}