using Domain.Entity;

namespace Domain.Entity
{
    public class Animal : Base
    {
        public long Id { get; set; }
        public int Idade { get; set; }
        public bool Sexo { get; set; }
        public bool PortadorDeficiencia { get; set; }
        public bool PortadorCongenita { get; set; }
        public string Nome { get; set; }
        public string Especie { get; set; }
        public string DescricaoDeficiencia { get; set; }
        public string DescricaoCongenita { get; set; }
        public string Foto { get; set; }
        
        //public virtual Doador Doador { get; set; }


        public override void Validate()
        {
            ClearValidationMessage();

            if (Idade == null)
            {
                AddError("Preencha a idade do animal.");
            }

            if (Sexo == null)
            {
                AddError("Preencha o sexo do animal.");
            }

            if (PortadorDeficiencia == null)
            {
                AddError("Preencha se o animal tem alguma defici�ncia.");
            }

            if (PortadorCongenita == null)
            {
                AddError("Preencha se o animal tem alguma doen�a cong�nita.");
            }

            if (string.IsNullOrEmpty(Nome))
            {
                AddError("Preencha o nome do animal.");
            }

            if (string.IsNullOrEmpty(Especie))
            {
                AddError("Preencha a especie do animal.");
            }

            if (string.IsNullOrEmpty(DescricaoDeficiencia))
            {
                AddError("Preencha com uma descri��o sobre a defici�ncia do animal.");
            }

            if (string.IsNullOrEmpty(DescricaoCongenita))
            {
                AddError("Preencha com uma descri��o sobre a doen�a cong�nita do animal.");
            }

            if (string.IsNullOrEmpty(Foto))
            {
                AddError("Neces�rio uma foto do animal.");
            }
        }
    }
}
