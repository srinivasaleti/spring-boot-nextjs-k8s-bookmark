export const Button = ({
  title,
  onClick = () => {},
  disable = false,
}: {
  title: string;
  onClick?: () => void;
  disable?: boolean;
}) => {
  return (
    <button
      style={{
        width: "240px",
        cursor: "pointer",
        height: "40px",
        fontWeight: "bold",
        fontSize: "14px",
      }}
      onClick={onClick}
      disabled={disable}
    >
      {title}
    </button>
  );
};
